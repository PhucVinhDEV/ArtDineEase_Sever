package com.BitzNomad.identity_service.Respository.httpclient;

import com.BitzNomad.identity_service.DtoReponese.ExchangeTokenReponese;
import com.BitzNomad.identity_service.DtoReponese.UserReponese;
import com.BitzNomad.identity_service.DtoRequest.ExchangeTokenRequest;
import com.BitzNomad.identity_service.DtoRequest.UserCreateRequest;
import feign.QueryMap;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "Created-Profile", url = "http://localhost:8080/profile")
public interface CreatedInterfaceClient {
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    UserReponese createUserProfile(@RequestBody UserCreateRequest request);
}
