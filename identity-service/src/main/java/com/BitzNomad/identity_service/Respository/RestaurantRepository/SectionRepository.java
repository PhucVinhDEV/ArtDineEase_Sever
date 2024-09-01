package com.BitzNomad.identity_service.Respository.RestaurantRepository;

import com.BitzNomad.identity_service.Entity.Restaurant.MenuSection;
import com.BitzNomad.identity_service.Entity.Restaurant.Section;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
@Lazy
public interface SectionRepository extends JpaRepository<Section, Long> {

    Page<Section> findAllByIsDeleted(boolean deleted, Pageable pageable);

//    Page<Section> findAllByIsDeletedAndFoodStoreId(boolean deleted, Pageable pageable,Long FoodStoreid);



    @Query("SELECT s FROM Section s WHERE s.isDeleted = :isDeleted AND s.foodStore.id = :foodStoreId")
    List<Section> findAllByIsDeletedAndFoodStoreId(@Param("isDeleted") boolean isDeleted, @Param("foodStoreId") Long foodStoreId);
}