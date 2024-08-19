package com.BitzNomad.identity_service.Mapper.Restaurant;

import com.BitzNomad.identity_service.DtoReponese.CategoryOfFoodStoreReponeseDTO;
import com.BitzNomad.identity_service.DtoRequest.CategoryOfFoodStoreRequestDTO;
import com.BitzNomad.identity_service.Entity.Restaurant.CategoryOfFoodStore;
import com.BitzNomad.identity_service.Respository.RestaurantRepository.CategoryOfFoodStoreRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CategoryOfFoodStoreMapper {

    @Autowired
    CategoryOfFoodStoreRepository categoryOfFoodStoreRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    FoodStoreMapper foodStoreMapper;
    public CategoryOfFoodStore convertRequestToCategoryOfFoodStore(CategoryOfFoodStoreRequestDTO categoryOfFoodStoreRequestDTO) {
        return modelMapper.map(categoryOfFoodStoreRequestDTO, CategoryOfFoodStore.class);
    }

    public CategoryOfFoodStoreReponeseDTO convertToReponeseDTO(CategoryOfFoodStore categoryOfFoodStore) {
        CategoryOfFoodStoreReponeseDTO categoryOfFoodStoreReponeseDTO = modelMapper.map(categoryOfFoodStore,CategoryOfFoodStoreReponeseDTO.class);
        categoryOfFoodStoreReponeseDTO.setFoodStoreReponeseSet(
                Optional.ofNullable(categoryOfFoodStore.getFoodStores())
                        .orElse(Set.of())
                        .stream()
                        .map(foodStoreMapper::convertFoodStoreToFoodStoreReponese)
                        .collect(Collectors.toSet())
        );
        return categoryOfFoodStoreReponeseDTO;
    }

}
