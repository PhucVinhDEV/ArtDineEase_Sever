package com.BitzNomad.identity_service.Respository.ImgRepository;

import com.BitzNomad.identity_service.Entity.Image.Banner;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Lazy
public interface BannerRepository extends JpaRepository<Banner,Long> {

    

    @Query("SELECT b FROM Banner b WHERE b.isDeleted = false AND b.TypeOfImg = :typeOfImg ORDER BY b.createdDate DESC")
    Optional<Banner> findLatestBanner(@Param("typeOfImg") String typeOfImg);
}
