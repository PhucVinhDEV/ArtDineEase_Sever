package com.BitzNomad.identity_service.Service.FoodStoreService;


import com.BitzNomad.identity_service.DtoRequest.TopicFoodStoreRequest;
import com.BitzNomad.identity_service.Entity.Restaurant.TopicFoodStore;

public interface TopicFoodStoreService {
    void  CreateTopicFoodStore(TopicFoodStoreRequest topicFoodStoreRequest);
    TopicFoodStore updateTopicFoodStore(TopicFoodStoreRequest topicFoodStoreRequest);
    void  DeleteTopicFoodStore(Long TopicID, Long FoodStoreID);
}
