package com.BitzNomad.identity_service.Service.AuthService;

import com.BitzNomad.identity_service.DtoReponese.PermissionReponese;
import com.BitzNomad.identity_service.DtoRequest.PermissionRequest;

import java.util.List;

public interface PermissionService {
    PermissionReponese create(PermissionRequest request);
   void delete(String permissionid);
   List<PermissionReponese> findAll();
}
