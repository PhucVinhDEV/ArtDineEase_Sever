package com.BitzNomad.identity_service.Service.RestaurantService;

import com.BitzNomad.identity_service.DtoReponese.ProductResponeseDTO;
import com.BitzNomad.identity_service.DtoRequest.ProductRegisterRequestDTO;
import com.BitzNomad.identity_service.DtoRequest.ProductRequestDTO;
import com.BitzNomad.identity_service.Service.BaseService;

public interface ProductService extends BaseService<ProductResponeseDTO, ProductRequestDTO,Long> {
    void CreatedProduct(ProductRegisterRequestDTO productRegisterRequestDTO) throws Exception;
}
