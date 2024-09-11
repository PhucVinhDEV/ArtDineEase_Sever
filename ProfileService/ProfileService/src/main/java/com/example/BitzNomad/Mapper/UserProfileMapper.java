package com.example.BitzNomad.Mapper;


import com.example.BitzNomad.DTO.UserReponese;
import com.example.BitzNomad.DTO.UserRequest;
import com.example.BitzNomad.Entity.UserProfile;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {
    UserProfile ToUserProfile(UserRequest userProfile);

    UserReponese ToUserReponese(UserProfile userProfile);
}
