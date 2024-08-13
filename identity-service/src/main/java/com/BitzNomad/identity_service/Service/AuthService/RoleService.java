package com.BitzNomad.identity_service.Service.AuthService;

import com.BitzNomad.identity_service.DtoReponese.RoleReponese;
import com.BitzNomad.identity_service.DtoRequest.RoleRequest;

import java.util.List;

public interface RoleService {
    RoleReponese create(RoleRequest request);
    void delete(String RoleId);
    List<RoleReponese> findAll();
    RoleReponese update(RoleRequest request);
}
