package com.example.BitzNomad.Rescontroller;


import com.example.BitzNomad.DTO.UserReponese;
import com.example.BitzNomad.DTO.UserRequest;
import com.example.BitzNomad.Service.UserProfileService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserProfileRescontroller {
    UserProfileService userProfileService;

    @PostMapping("/")
    UserReponese createUserProfile(@RequestBody UserRequest request) {
        return userProfileService.saveUserProfile(request);
    }

    @GetMapping("/")
    List<UserReponese> GetUserProfile() {
        return userProfileService.GetUserProfile();
    }
}
