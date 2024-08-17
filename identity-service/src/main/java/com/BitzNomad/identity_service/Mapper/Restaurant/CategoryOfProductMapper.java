package com.BitzNomad.identity_service.Mapper.Restaurant;


import com.BitzNomad.identity_service.DtoReponese.CategoryOfProdcutReponeseDTO;
import com.BitzNomad.identity_service.DtoRequest.CategoryOfProductRequestDTO;
import com.BitzNomad.identity_service.Entity.Restaurant.CatagoryOfProduct;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashSet;
import java.util.stream.Collectors;

@Component
public class CategoryOfProductMapper {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ProductMapper productMapper;
    public CatagoryOfProduct convertRequsetToEntity(CategoryOfProductRequestDTO catagoryOfProduct) {
        return modelMapper.map(catagoryOfProduct, CatagoryOfProduct.class);
    }

    public CategoryOfProdcutReponeseDTO convertEntityToReponese(CatagoryOfProduct catagoryOfProduct) {
        CategoryOfProdcutReponeseDTO categoryOfProdcutReponeseDTO = modelMapper.map(catagoryOfProduct, CategoryOfProdcutReponeseDTO.class);
        if (catagoryOfProduct.getProducts() == null || catagoryOfProduct.getProducts().isEmpty()) {
            categoryOfProdcutReponeseDTO.setProducts(Collections.emptySet());
        } else {
            categoryOfProdcutReponeseDTO.setProducts(
                    catagoryOfProduct.getProducts().stream()
                            .map(productMapper::convertProductToProductResponeseDTO)
                            .collect(Collectors.toSet())
            );
        }
        return categoryOfProdcutReponeseDTO;
    }
}
