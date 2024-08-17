package com.BitzNomad.identity_service.Respository;

import com.BitzNomad.identity_service.Entity.Auth.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, String> {
}
