package com.BitzNomad.identity_service.Mapper.FoodStore;

import com.BitzNomad.identity_service.DtoReponese.AttributeResponese;
import com.BitzNomad.identity_service.DtoRequest.AttributeRequestDTO;
import com.BitzNomad.identity_service.Entity.Restaurant.Attribute;
import com.BitzNomad.identity_service.Respository.RestaurantRepository.AttributeRepository;
import com.BitzNomad.identity_service.Respository.RestaurantRepository.FoodStoreRepository;
import org.hibernate.annotations.Cache;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AttributeMapper {


    @Autowired
    FoodStoreRepository foodStoreRepository;

    @Autowired
    ModelMapper modelMapper;

    public Attribute convertRequestToEntity(AttributeRequestDTO attributeRequestDTO){
        Attribute attribute = modelMapper.map(attributeRequestDTO, Attribute.class);
        attribute.setFoodStore(foodStoreRepository.findById(attributeRequestDTO.getFoodstoreId()).orElseThrow(
                () -> new RuntimeException("Invalid foodstore id: " + attributeRequestDTO.getFoodstoreId())
        ));
        return attribute;
    }

    public AttributeResponese convertEntityToResponese(Attribute attribute){
        return modelMapper.map(attribute, AttributeResponese.class);
    }

}
