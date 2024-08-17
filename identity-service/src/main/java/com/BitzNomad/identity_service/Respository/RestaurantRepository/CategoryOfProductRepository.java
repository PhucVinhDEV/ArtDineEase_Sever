package com.BitzNomad.identity_service.Respository.RestaurantRepository;

import com.BitzNomad.identity_service.Entity.Restaurant.CatagoryOfProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryOfProductRepository extends JpaRepository<CatagoryOfProduct,Long> {
}
