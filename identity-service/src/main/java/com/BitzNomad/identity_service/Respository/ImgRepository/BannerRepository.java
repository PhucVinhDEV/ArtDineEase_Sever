package com.BitzNomad.identity_service.Respository.ImgRepository;

import com.BitzNomad.identity_service.Entity.Image.Banner;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Lazy
public interface BannerRepository extends JpaRepository<Banner,Long> {
}
