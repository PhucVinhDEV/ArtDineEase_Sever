package com.BitzNomad.identity_service.Respository.RestaurantRepository;

import com.BitzNomad.identity_service.Entity.Restaurant.TopicFoodStore;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Lazy
public interface TopicOfFoodStoreRepository extends JpaRepository<TopicFoodStore,Long> {

    boolean existsByTopicIdAndFoodStoreId(Long topicId, Long foodStoreId);

    TopicFoodStore findByTopicIdAndFoodStoreId(Long topicId, Long foodStoreId);
}
