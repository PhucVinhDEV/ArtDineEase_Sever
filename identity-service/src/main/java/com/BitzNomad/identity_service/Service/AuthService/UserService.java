package com.BitzNomad.identity_service.Service.AuthService;

import com.BitzNomad.identity_service.DtoReponese.UserReponese;
import com.BitzNomad.identity_service.DtoRequest.UserCreateRequest;
import com.BitzNomad.identity_service.DtoRequest.UserUpdateRequest;
import com.BitzNomad.identity_service.Entity.Auth.User;

import java.util.List;


public interface UserService {

    UserReponese createUser(UserCreateRequest request);

    UserReponese getMyInfo();

    User getUserById(String id);

    User updateUser(UserUpdateRequest request);

    void deleteUser(String id);

    List<UserReponese> getAllUsers();


    boolean existsByUsername(String email);
}

