package com.BitzNomad.identity_service.Respository.RestaurantRepository;

import com.BitzNomad.identity_service.DtoReponese.AttributeResponese;
import com.BitzNomad.identity_service.Entity.Restaurant.Attribute;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Lazy
public interface AttributeRepository extends JpaRepository<Attribute, Long> {

    List<Attribute> findAllByFoodStoreId(Long foodstoreId);
}
