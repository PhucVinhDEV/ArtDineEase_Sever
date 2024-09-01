package com.BitzNomad.identity_service.Respository.RestaurantRepository;

import com.BitzNomad.identity_service.Entity.Restaurant.MenuSection;
import com.BitzNomad.identity_service.Entity.Restaurant.Section;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Lazy
public interface MenuSectionRepository extends JpaRepository<MenuSection, Long> {

    boolean existsByProductSizeIdAndSectionId(Long productSizeId, Long sectionId);


    Optional<MenuSection> findByProductSizeIdAndSectionId(Long productSizeId, Long sectionId);

    Page<MenuSection> findBySectionAndIsDeleted(Section section,Boolean deleted ,Pageable pageable);
}
