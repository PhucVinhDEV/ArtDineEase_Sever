package com.BitzNomad.identity_service.Respository;

import com.BitzNomad.identity_service.Entity.InvalidatedToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InvalidatedRepository extends JpaRepository<InvalidatedToken,String> {
}
