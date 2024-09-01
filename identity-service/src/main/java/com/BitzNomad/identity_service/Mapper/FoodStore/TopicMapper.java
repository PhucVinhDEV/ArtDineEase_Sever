package com.BitzNomad.identity_service.Mapper.FoodStore;

import com.BitzNomad.identity_service.DtoReponese.FoodStoreReponese;
import com.BitzNomad.identity_service.DtoReponese.FootstoreReponeseBanner;
import com.BitzNomad.identity_service.DtoReponese.TopicReponese;
import com.BitzNomad.identity_service.DtoRequest.TopicRequestDTO;
import com.BitzNomad.identity_service.Entity.Restaurant.Topic;
import com.BitzNomad.identity_service.Entity.Restaurant.TopicFoodStore;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class TopicMapper {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    FoodStoreMapper foodStoreMapper;

    public Topic convertTopicRequstToTopic(TopicRequestDTO requestDTO) {
        return modelMapper.map(requestDTO, Topic.class);
    }

    public TopicReponese convertTopicToTopicReponese(Topic topic) {
        TopicReponese topicReponese = modelMapper.map(topic, TopicReponese.class);
        Set<FootstoreReponeseBanner> foodStoreResponses = Optional.ofNullable(topic.getTopicFoodStores())
                .orElse(Set.of()) // Nếu là null, trả về Set rỗng
                .stream()
                .map(TopicFoodStore::getFoodStore)
                .map(foodStoreMapper::convertFoodStoreToFoodStoreReponeseBanner)
                .collect(Collectors.toSet());
        topicReponese.setTopicFoodStores(foodStoreResponses);
        return topicReponese;
    }
}
