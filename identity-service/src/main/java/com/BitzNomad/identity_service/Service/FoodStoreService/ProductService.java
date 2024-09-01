package com.BitzNomad.identity_service.Service.FoodStoreService;

import com.BitzNomad.identity_service.DtoReponese.ProductResponeseDTO;
import com.BitzNomad.identity_service.DtoRequest.ProductRegisterRequestDTO;
import com.BitzNomad.identity_service.DtoRequest.ProductRequestDTO;
import com.BitzNomad.identity_service.Service.BaseService;

import java.util.List;

public interface ProductService extends BaseService<ProductResponeseDTO, ProductRequestDTO,Long> {
    void CreatedProduct(ProductRegisterRequestDTO productRegisterRequestDTO) throws Exception;

    List<ProductResponeseDTO> GetAllProductsByFoodstoreID(Long foodstoreId) throws Exception;

}
