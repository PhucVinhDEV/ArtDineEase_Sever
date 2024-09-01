package com.BitzNomad.identity_service.Mapper.FoodStore;

import com.BitzNomad.identity_service.DtoReponese.ProductResponeseDTO;
import com.BitzNomad.identity_service.DtoRequest.ProductRegisterRequestDTO;
import com.BitzNomad.identity_service.DtoRequest.ProductRequestDTO;
import com.BitzNomad.identity_service.Entity.Restaurant.Product;
import com.BitzNomad.identity_service.Mapper.ImageMapper;
import com.BitzNomad.identity_service.Respository.RestaurantRepository.CategoryOfProductRepository;
import com.BitzNomad.identity_service.Respository.RestaurantRepository.FoodStoreRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ProductMapper {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    FoodStoreRepository foodStoreRepository;

    @Autowired
    CategoryOfProductRepository categoryOfProductRepository;

    @Autowired
    ImageMapper imageMapper;

    @Autowired
    ProductSizeMapper productSizeMapper;

    public Product convertProductRequestToProduct(ProductRequestDTO productRequestDTO) {
        Product p = modelMapper.map(productRequestDTO, Product.class);
        p.setFoodStore(foodStoreRepository.findById(productRequestDTO.getFoodStoreID()).orElseThrow(
                () -> new RuntimeException("notfound foodStoreID: " + productRequestDTO.getFoodStoreID())
        ));
        p.setCatagory(categoryOfProductRepository.findById(productRequestDTO.getCatagoryID()).orElseThrow(
                () -> new RuntimeException("notfound categoryID: " + productRequestDTO.getCatagoryID())
        ));
        return  p;
    }

    public ProductResponeseDTO convertProductToProductResponeseDTO(Product product) {
        ProductResponeseDTO p = modelMapper.map(product, ProductResponeseDTO.class);
        p.setCategory(product.getCatagory().getName());
       if (product.getImageOfProducts() == null || product.getImageOfProducts().isEmpty()) {
           p.setImageDTOReponeseSet(Set.of());
       }else {
           p.setImageDTOReponeseSet(
                   product.getImageOfProducts().stream().map(imageMapper::convertImgProductToImageDTOReponese).collect(Collectors.toSet())
           );
       }
        if(product.getProductSizes()!=null && !product.getProductSizes().isEmpty()){
            p.setProductSizeReponeseDTOSet(
                    product.getProductSizes().stream().map(productSizeMapper::convertProductSizeToProductSizeReponeseDTO).collect(Collectors.toSet())
            );
        } else p.setProductSizeReponeseDTOSet(Set.of());

        return p;
    }

    public Product ConvertProductRegisterToProduct(ProductRegisterRequestDTO productRegisterRequestDTO) {
        Product p = modelMapper.map(productRegisterRequestDTO, Product.class);
        p.setFoodStore(foodStoreRepository.findById(productRegisterRequestDTO.getFoodStoreId()).orElseThrow(
                () -> new RuntimeException("notfound foodStoreID: " + productRegisterRequestDTO.getFoodStoreId())
        ));
        p.setCatagory(categoryOfProductRepository.findById(productRegisterRequestDTO.getCategoryId()).orElseThrow(
                () -> new RuntimeException("notfound categoryID: " + productRegisterRequestDTO.getCategoryId())
        ));
        return p;
    }

}
