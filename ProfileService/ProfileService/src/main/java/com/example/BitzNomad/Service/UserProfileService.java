package com.example.BitzNomad.Service;


import com.example.BitzNomad.DTO.UserReponese;
import com.example.BitzNomad.DTO.UserRequest;
import com.example.BitzNomad.Entity.UserProfile;
import com.example.BitzNomad.Mapper.UserProfileMapper;
import com.example.BitzNomad.Repository.userProfileRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
@Slf4j
public class UserProfileService {

    userProfileRepository userRepository;

    UserProfileMapper userProfileMapper;

    public UserReponese saveUserProfile(UserRequest request) {
        UserProfile userProfile1 = userProfileMapper.ToUserProfile(request);
        UserProfile userProfile2 = saveUserProfile(userProfile1);
        return  userProfileMapper.ToUserReponese(userProfile2);
    }

    public List<UserReponese> GetUserProfile() {
        return userRepository.findAll().stream().map(userProfileMapper::ToUserReponese).toList();
    }

    @Transactional
    public UserProfile saveUserProfile(UserProfile userProfile) {
        return userRepository.save(userProfile);
    }
}
