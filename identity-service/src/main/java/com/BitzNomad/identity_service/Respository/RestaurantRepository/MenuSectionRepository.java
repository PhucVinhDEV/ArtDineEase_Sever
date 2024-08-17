package com.BitzNomad.identity_service.Respository.RestaurantRepository;

import com.BitzNomad.identity_service.Entity.Restaurant.MenuSection;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Lazy
public interface MenuSectionRepository extends JpaRepository<MenuSection, Long> {
}
