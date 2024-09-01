package com.BitzNomad.identity_service.Respository.ImgRepository;

import com.BitzNomad.identity_service.Entity.Image.ImageOfFoodStore;

import feign.Param;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Lazy
public interface ImageOfFoodStoreRepository extends JpaRepository<ImageOfFoodStore, Integer> {

    @Query("SELECT i FROM ImageOfFoodStore i WHERE i.isDeleted = false AND i.TypeOfImg = :typeOfImg AND i.foodStore.id = :foodStoreId ORDER BY i.createdDate DESC")
    Optional<ImageOfFoodStore> findLatestImage(@Param("typeOfImg") String typeOfImg, @Param("foodStoreId") Long foodStoreId);

}
