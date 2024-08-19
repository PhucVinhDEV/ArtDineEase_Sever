package com.BitzNomad.identity_service.Mapper.Restaurant;

import com.BitzNomad.identity_service.DtoRequest.TopicFoodStoreRequest;
import com.BitzNomad.identity_service.Entity.Restaurant.TopicFoodStore;
import com.BitzNomad.identity_service.Respository.RestaurantRepository.FoodStoreRepository;
import com.BitzNomad.identity_service.Respository.RestaurantRepository.TopicRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicFoodStoreMapper {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    FoodStoreRepository foodStoreRepository;

    @Autowired
    TopicRepository topicRepository;

    public TopicFoodStore convertRequestToEntity(TopicFoodStoreRequest topicFoodStoreRequest) {
        TopicFoodStore topicFoodStore = modelMapper.map(topicFoodStoreRequest, TopicFoodStore.class);
        topicFoodStore.setFoodStore(
                foodStoreRepository.findById(topicFoodStoreRequest.getFoodStoreId()).orElseThrow(
                        () -> new RuntimeException("Invalid foodStore Id: " + topicFoodStoreRequest.getFoodStoreId())
                )
        );
        topicFoodStore.setTopic(topicRepository.findById(topicFoodStoreRequest.getTopicId()).orElseThrow(
                () -> new RuntimeException("Invalid topic Id: " + topicFoodStoreRequest.getTopicId())
        ));
        return topicFoodStore;
    }
}
