package com.BitzNomad.identity_service.Respository.ImgRepository;

import com.BitzNomad.identity_service.Entity.Image.ImageOfProductSize;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Lazy
public interface ImageOfProductSizeRepository extends JpaRepository<ImageOfProductSize, Long> {
}
