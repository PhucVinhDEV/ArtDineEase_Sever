package com.BitzNomad.identity_service.Mapper.Restaurant;

import com.BitzNomad.identity_service.DtoReponese.FoodStoreReponese;

import com.BitzNomad.identity_service.DtoRequest.FoodStoreRegisterRequestDTO;



import com.BitzNomad.identity_service.Entity.Restaurant.FoodStore;

import com.BitzNomad.identity_service.Entity.Restaurant.TopicFoodStore;
import com.BitzNomad.identity_service.Mapper.ImageMapper;
import com.BitzNomad.identity_service.Respository.RestaurantRepository.CategoryOfFoodStoreRepository;
import com.BitzNomad.identity_service.Respository.RestaurantRepository.TopicOfFoodStoreRepository;
import com.BitzNomad.identity_service.Respository.RestaurantRepository.TopicRepository;
import com.BitzNomad.identity_service.Respository.UserRepository;
import com.BitzNomad.identity_service.Service.CloudiaryService.CloudinaryService;
import org.modelmapper.ModelMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FoodStoreMapper {

    private static final Logger log = LoggerFactory.getLogger(FoodStoreMapper.class);
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ImageMapper imageMapper;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CategoryOfFoodStoreRepository categoryOfFoodStoreRepository;

    @Autowired
    TopicRepository topicRepository;

    @Autowired
    TopicOfFoodStoreRepository TopicOfFoodStoreRepository;

    @Autowired
    CloudinaryService cloudinaryService;

    public FoodStoreReponese convertFoodStoreToFoodStoreReponese(FoodStore foodStore) {
        FoodStoreReponese res = modelMapper.map(foodStore, FoodStoreReponese.class);
        if (foodStore.getImageOfFoodStores() == null) {
            res.setImageDTOReponeseList(List.of());
        } else {
            res.setImageDTOReponeseList(foodStore.getImageOfFoodStores().stream()
                    .map(imageMapper::convertImageOfRestaurantToImageDTOReponese).toList());
        }
        return res;
    }

    public FoodStore convertFoodStoreRequestToFoodStore(FoodStoreRegisterRequestDTO foodStoreRegisterRequestDTO) {
        FoodStore foodStore = modelMapper.map(foodStoreRegisterRequestDTO, FoodStore.class);
        foodStore.setOwner(userRepository.findByEmail(foodStoreRegisterRequestDTO.getEmail())
                .orElseThrow(() -> new RuntimeException("User Not Found")));
        foodStore.setCatagory(categoryOfFoodStoreRepository.findById(foodStoreRegisterRequestDTO.getCategoryId()).orElseThrow(
                () -> new RuntimeException("Category Not Found")
        ));
        return foodStore;
    }

}
