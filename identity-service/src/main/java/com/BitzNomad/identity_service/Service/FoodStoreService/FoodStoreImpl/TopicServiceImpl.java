package com.BitzNomad.identity_service.Service.FoodStoreService.FoodStoreImpl;

import com.BitzNomad.identity_service.DtoReponese.TopicReponese;
import com.BitzNomad.identity_service.DtoRequest.TopicRequestDTO;
import com.BitzNomad.identity_service.Entity.Restaurant.Topic;
import com.BitzNomad.identity_service.Mapper.FoodStore.TopicMapper;
import com.BitzNomad.identity_service.Respository.RestaurantRepository.TopicRepository;
import com.BitzNomad.identity_service.Service.FoodStoreService.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
@Lazy
public class TopicServiceImpl implements TopicService {

    @Autowired
    TopicRepository topicRepository;

    @Autowired
    TopicMapper topicMapper;

    @Override
    public TopicReponese findById(Long id) {
        return topicMapper.convertTopicToTopicReponese(topicRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Topic not found")
        ));
    }

    @Override
    public TopicReponese save(TopicRequestDTO entity) {
        return topicMapper.convertTopicToTopicReponese(topicRepository.save(topicMapper.convertTopicRequstToTopic(entity)));
    }

    @Override
    public TopicReponese update(TopicRequestDTO entity) {
        if(topicRepository.existsById(entity.getId())){
            return topicMapper.convertTopicToTopicReponese(topicRepository.save(topicMapper.convertTopicRequstToTopic(entity)));
        }else
            throw new RuntimeException("Topic not found");
    }

    @Override
    public void deleteById(Long id) {
        Topic topic = topicRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Topic not found")
        );
        topic.setDeleted(true);
        topicRepository.save(topic);
    }

    @Override
    public Iterator<TopicReponese> findAll() {
        return topicRepository.findAllByIsDeleted(false).stream().map(topicMapper::convertTopicToTopicReponese).iterator();
    }
}
