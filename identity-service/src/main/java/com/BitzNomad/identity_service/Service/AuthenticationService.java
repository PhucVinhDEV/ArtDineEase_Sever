package com.BitzNomad.identity_service.Service;

import com.BitzNomad.identity_service.DtoReponese.AuthenticationResponse;
import com.BitzNomad.identity_service.DtoReponese.IntrospecResponsee;
import com.BitzNomad.identity_service.DtoReponese.UserReponese;
import com.BitzNomad.identity_service.DtoRequest.*;
import com.BitzNomad.identity_service.Exception.AppException;
import com.BitzNomad.identity_service.Exception.ErrorCode;
import com.BitzNomad.identity_service.Mapper.Auth.UserMapper;
import com.BitzNomad.identity_service.Utils.RandomPasswordGenerator;
import com.BitzNomad.identity_service.contant.PredefineRole;
import com.BitzNomad.identity_service.Entity.InvalidatedToken;
import com.BitzNomad.identity_service.Entity.Auth.Role;
import com.BitzNomad.identity_service.Entity.Auth.User;
import com.BitzNomad.identity_service.Respository.InvalidatedRepository;
import com.BitzNomad.identity_service.Respository.httpclient.OutboundIdentityClient;
import com.BitzNomad.identity_service.Respository.UserRepository;
import com.BitzNomad.identity_service.Respository.httpclient.OutboundUserClient;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationService {


    @Autowired
    UserRepository userRepository;

    @Autowired
    InvalidatedRepository invalidatedTokenRepository;

    @Autowired
    OutboundIdentityClient outboundIdentityClient;

    @Autowired
    OutboundUserClient  outboundUserClient;

    @Value("${jwt.secretKey}")
    private String SignerKey;

    @NonFinal
    @Value("${jwt.valid-duration}")
    protected long VALID_DURATION;

    @NonFinal
    @Value("${jwt.refreshable-duration}")
    protected long REFRESHABLE_DURATION;

    @NonFinal
    @Value("${outbound.identity.client-id}")
    protected String OUTBOUND_IDENTITY_CLIENT_ID;

    @NonFinal
    @Value("${outbound.identity.redirect-uri}")
    protected String OUTBOUND_IDENTITY_REDIRECT_URI;

    @NonFinal
    @Value("${outbound.identity.client-secret}")
    protected String OUTBOUND_IDENTITY_CLIENT_SECRET;

    @NonFinal
    protected final String GRANT_TYPE = "authorization_code";

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    UserMapper userMapper;

    @Autowired
    MailerService mailerService;

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        var user = userRepository.findByEmail(request.getUsername()).orElseThrow(() -> new AppException(ErrorCode.UserExitsted));
        boolean authenticated = passwordEncoder.matches(request.getPassword(), user.getPassword());
        if (!authenticated) {
            throw new AppException(ErrorCode.USER_NOT_EXISTED);
        }

        String token = generateToken(user);
        return  AuthenticationResponse.builder()
                .token(token)
                .authenticated(authenticated)
                .build();
    }

    public String generateToken(User user) {

        JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);

        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(user.getEmail())
                .issuer("BitzNomad.com")
                .issueTime(new Date())
                .expirationTime(new Date(
                        Instant.now().plus(VALID_DURATION, ChronoUnit.SECONDS).toEpochMilli()
                ))
                .jwtID(UUID.randomUUID().toString())
                .claim("scope",buildScope(user))
                .build();
        Payload payload = new Payload(jwtClaimsSet.toJSONObject());

        JWSObject jwsObject = new JWSObject(header, payload);

        try {
            jwsObject.sign(new MACSigner(SignerKey.getBytes()));
            return jwsObject.serialize();
        } catch (JOSEException e) {
            log.error("JWT Exception", e);
            throw new RuntimeException(e);
        }
    }
    public AuthenticationResponse refeshToken(RefeshRequest request) throws ParseException, JOSEException {

            var SingJWT = VerifyToken(request.getToken(),true);

            var jit = SingJWT.getJWTClaimsSet().getJWTID();

            var expirationTime = SingJWT.getJWTClaimsSet().getExpirationTime();

            InvalidatedToken invalidatedToken = InvalidatedToken.builder()
                    .id(jit)
                    .expiryTime(expirationTime)
                    .build();

            invalidatedTokenRepository.save(invalidatedToken);

            var u = SingJWT.getJWTClaimsSet().getSubject();

            var user = userRepository.findByEmail(u).orElseThrow(
                    () -> new AppException(ErrorCode.UNAUTHORIZED)
            );


        String token = generateToken(user);
        return  AuthenticationResponse.builder()
                .token(token)
                .authenticated(true)
                .build();
    }
    public void logout(LogoutRequest request) throws ParseException, JOSEException {
        try {
            SignedJWT signToken = VerifyToken(request.getToken(),false);

            String jit = signToken.getJWTClaimsSet().getJWTID();
            Date expiryTime = signToken.getJWTClaimsSet().getExpirationTime();

            InvalidatedToken invalidatedToken =
                    InvalidatedToken.builder().id(jit).expiryTime(expiryTime).build();

            invalidatedTokenRepository.save(invalidatedToken);
        }catch (AppException exception){
            log.info("Token already expired");
        };
    }
    public IntrospecResponsee Instropec(IntrospecRequest request) throws JOSEException, ParseException {

                boolean isValid = true;

                try{
                    VerifyToken(request.getToken(),false);
                }catch (AppException exception){
                    isValid = false;
                }

        return IntrospecResponsee.builder()
                .valid(isValid)
                .expiration( VerifyToken(request.getToken(),false).getJWTClaimsSet().getExpirationTime())
                .build();
    }

    private String buildScope(User user) {
        StringJoiner stringJoiner = new StringJoiner(" ");

        if (!CollectionUtils.isEmpty(user.getRoles()))
            user.getRoles().forEach(role -> {
                stringJoiner.add("ROLE_" + role.getName());
                if (!CollectionUtils.isEmpty(role.getPermissions()))
                    role.getPermissions().stream().filter(permission -> !permission.isDeleted()).forEach(permission -> stringJoiner.add(permission.getName()));
            });
        return stringJoiner.toString();
    }
    private SignedJWT VerifyToken(String token,boolean isRefesh) throws ParseException, JOSEException {
        JWSVerifier verifier = new MACVerifier(SignerKey.getBytes());

        SignedJWT signedJWT = SignedJWT.parse(token);

        //If isResh = true get ExpriTime to Refesh token
        //neu la refesh Expritime = GetissueTime +  REFRESHABLE_DURATION
        // neu ko phai resh expriTime = signedJWT.expritime
        Date expriTime = (isRefesh) ?
                new Date(signedJWT.getJWTClaimsSet().getIssueTime()
                        .toInstant().plus(REFRESHABLE_DURATION,ChronoUnit.SECONDS).toEpochMilli())
                : signedJWT.getJWTClaimsSet().getExpirationTime();

        var verified = signedJWT.verify(verifier);
        if(!(verified && expriTime.after(new Date()))) throw  new AppException(ErrorCode.UNAUTHENTICATED);
        if(invalidatedTokenRepository.existsById(signedJWT.getJWTClaimsSet().getJWTID()))
            throw new AppException(ErrorCode.UNAUTHENTICATED);

        return signedJWT;
    }

    public AuthenticationResponse outboundAuthenticate(String code){
        var response = outboundIdentityClient.exchangeToken(ExchangeTokenRequest.builder()
                        .code(code)
                        .clientId(OUTBOUND_IDENTITY_CLIENT_ID)
                        .redirectUri(OUTBOUND_IDENTITY_REDIRECT_URI)
                        .clientSecret(OUTBOUND_IDENTITY_CLIENT_SECRET)
                        .grantType(GRANT_TYPE)
                .build());


        var userInfo = outboundUserClient.GetUserInfo("json",response.getAccessToken());
        Set<Role> roles = new HashSet<>();
        roles.add(Role.builder()
                .name(PredefineRole.USER_ROLE)
                .build());
        var password = RandomPasswordGenerator.generateRandomPassword(8);
        var user = userRepository.findByEmail(userInfo.getEmail()).orElseGet(
                () -> userRepository.save(User.builder()
                                .firstName(userInfo.getGivenName())
                                .email(userInfo.getEmail())
                                .password(passwordEncoder.encode(password))
                                .lastName(userInfo.getFamilyName())
                                .roles(roles)
                        .build())
        );

        //Onbard token Google -> systemToken

        var token = generateToken(user);


        UserReponese u = userMapper.convertUserToReponese(user);
        MailInfo mailSend = new MailInfo();
        mailSend.setFrom("ArtDineEase");
        mailSend.setTo(u.getEmail());
        mailSend.setSubject("Your Temporary Password With ArtDineEase");
        mailSend.setBody(formatEmailBody(u,password));
        try {
            mailerService.send(mailSend);

        } catch (MessagingException e) {
            throw new RuntimeException(e.getMessage());
        }

        return AuthenticationResponse.builder()
                .authenticated(true)
                .token(token)
                .build();
    }
    private String formatEmailBody( UserReponese user , String temporaryPassword) {
        return "<html>" +
                "<head>" +
                "<style>" +
                "body { font-family: Arial, sans-serif; line-height: 1.6; margin: 0; padding: 0; background-color: #f4f4f4; }" +
                ".container { width: 80%; margin: 0 auto; background-color: #ffffff; padding: 20px; border-radius: 10px; box-shadow: 0 2px 4px rgba(0,0,0,0.1); }" +
                "h2 { color: #333333; }" +
                "p { color: #555555; }" +
                ".temporary-password { font-size: 20px; font-weight: bold; color: #e63946; }" +
                ".footer { margin-top: 20px; font-size: 12px; color: #888888; }" +
                "</style>" +
                "</head>" +
                "<body>" +
                "<div class='container'>" +
                "<h2>Your Temporary Password</h2>" +
                "<p>Dear " + user.getLastName() + " " + user.getFirstName() + ",</p>" +
                "<p>Your temporary password is:</p>" +
                "<p class='temporary-password'>" + temporaryPassword + "</p>" +
                "<p>Please use this password to log in and update your password immediately to ensure the security of your account.</p>" +
                "<br>" +
                "<p>Best regards,</p>" +
                "<p>ArtDineEase</p>" +
                "<div class='footer'>" +
                "<p>If you did not request this password reset, please ignore this email or contact support immediately.</p>" +
                "<p>&copy; 2024 ArtDineEase. All rights reserved.</p>" +
                "</div>" +
                "</div>" +
                "</body>" +
                "</html>";
    }
}
