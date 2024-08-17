package com.BitzNomad.identity_service.Respository;

import com.BitzNomad.identity_service.Entity.Auth.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
}
