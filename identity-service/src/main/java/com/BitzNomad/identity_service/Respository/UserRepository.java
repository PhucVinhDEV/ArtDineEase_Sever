package com.BitzNomad.identity_service.Respository;

import com.BitzNomad.identity_service.Entity.Auth.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    boolean existsByEmail(String email);


    Optional<User> findByEmail(String email);


}
