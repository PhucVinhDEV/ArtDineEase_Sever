package com.BitzNomad.identity_service.repository;

import com.BitzNomad.identity_service.entity.Auth.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
}
