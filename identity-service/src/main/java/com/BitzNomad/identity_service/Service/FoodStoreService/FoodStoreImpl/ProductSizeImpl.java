package com.BitzNomad.identity_service.Service.FoodStoreService.FoodStoreImpl;

import com.BitzNomad.identity_service.DtoReponese.ProductSizeReponeseDTO;
import com.BitzNomad.identity_service.DtoRequest.ProductSizeRegisterRequestDTO;
import com.BitzNomad.identity_service.Entity.Restaurant.ProductSize;
import com.BitzNomad.identity_service.Mapper.Restaurant.ProductSizeMapper;
import com.BitzNomad.identity_service.Respository.RestaurantRepository.ProductSizeRepository;
import com.BitzNomad.identity_service.Service.CloudiaryService.ImageOfProductSizeService;
import com.BitzNomad.identity_service.Service.FoodStoreService.ProductSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductSizeImpl implements ProductSizeService {

    @Autowired
    ProductSizeRepository productSizeRepository;

    @Autowired
    ProductSizeMapper productSizeMapper;

    @Autowired
    ImageOfProductSizeService imageOfProductSizeService;

    @Override
    public void CreatedProductSize(ProductSizeRegisterRequestDTO productSize) throws Exception {
        ProductSize p = productSizeRepository.save(productSizeMapper.convertProductSizeRequestDTOToProductSize(productSize));
        imageOfProductSizeService.saveImageOfProductSize(productSize.getMultipartFiles(), p.getId(),"MainIamge");
    }

    @Override
    public ProductSizeReponeseDTO UpdatedProductSize(ProductSizeRegisterRequestDTO productSize) {
        return null;
    }
}
