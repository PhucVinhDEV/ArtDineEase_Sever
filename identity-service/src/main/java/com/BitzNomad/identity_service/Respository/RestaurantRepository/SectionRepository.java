package com.BitzNomad.identity_service.Respository.RestaurantRepository;

import com.BitzNomad.identity_service.Entity.Restaurant.Section;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Lazy
public interface SectionRepository extends JpaRepository<Section, Long> {
}
