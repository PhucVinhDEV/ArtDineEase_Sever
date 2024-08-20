package com.BitzNomad.identity_service.Service.FoodStoreService;

import com.BitzNomad.identity_service.DtoReponese.ProductSizeReponeseDTO;
import com.BitzNomad.identity_service.DtoRequest.ProductSizeRegisterRequestDTO;
import com.BitzNomad.identity_service.Entity.Restaurant.ProductSize;

public interface ProductSizeService {
    void CreatedProductSize(ProductSizeRegisterRequestDTO productSize) throws Exception;
    ProductSizeReponeseDTO UpdatedProductSize(ProductSizeRegisterRequestDTO productSize);
}
