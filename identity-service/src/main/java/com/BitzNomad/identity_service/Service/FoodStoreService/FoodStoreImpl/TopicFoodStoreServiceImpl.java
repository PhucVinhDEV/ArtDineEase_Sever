package com.BitzNomad.identity_service.Service.FoodStoreService.FoodStoreImpl;

import com.BitzNomad.identity_service.DtoRequest.TopicFoodStoreRequest;
import com.BitzNomad.identity_service.Entity.Restaurant.TopicFoodStore;
import com.BitzNomad.identity_service.Mapper.Restaurant.TopicFoodStoreMapper;
import com.BitzNomad.identity_service.Respository.RestaurantRepository.TopicOfFoodStoreRepository;
import com.BitzNomad.identity_service.Service.FoodStoreService.TopicFoodStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy
public class TopicFoodStoreServiceImpl implements TopicFoodStoreService {

    @Autowired
    TopicFoodStoreMapper topicFoodStoreMapper;

    @Autowired
    TopicOfFoodStoreRepository topicOfFoodStoreRepository;


    @Override
    public void CreateTopicFoodStore(TopicFoodStoreRequest topicFoodStoreRequest) {
        if (topicOfFoodStoreRepository.existsByTopicIdAndFoodStoreId(topicFoodStoreRequest.getTopicId(), topicFoodStoreRequest.getFoodStoreId())) {
            throw new RuntimeException("Topic already exists");
        } else {
            topicOfFoodStoreRepository.save(topicFoodStoreMapper.convertRequestToEntity(topicFoodStoreRequest));
        }
    }

    @Override
    public TopicFoodStore updateTopicFoodStore(TopicFoodStoreRequest topicFoodStoreRequest) {
        if(topicOfFoodStoreRepository.existsByTopicIdAndFoodStoreId(topicFoodStoreRequest.getTopicId(), topicFoodStoreRequest.getFoodStoreId())) {
            return  topicOfFoodStoreRepository.save(topicFoodStoreMapper.convertRequestToEntity(topicFoodStoreRequest));
        }else {
            throw new RuntimeException("Topic does not exist");
        }

    }

    @Override
    public void DeleteTopicFoodStore(Long TopicID, Long FoodStoreID) {
    TopicFoodStore topicFoodStore =  topicOfFoodStoreRepository.findByTopicIdAndFoodStoreId(TopicID, FoodStoreID);
    if(topicFoodStore!=null) {
        topicFoodStore.setDeleted(true);
        topicOfFoodStoreRepository.save(topicFoodStore);
    }else throw new RuntimeException("Topic does not exist");
    }
}
