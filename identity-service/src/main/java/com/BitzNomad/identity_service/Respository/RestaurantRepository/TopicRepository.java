package com.BitzNomad.identity_service.Respository.RestaurantRepository;

import com.BitzNomad.identity_service.Entity.Restaurant.Topic;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Lazy
public interface TopicRepository extends JpaRepository<Topic, Long> {
    List<Topic> findAllByIsDeleted(boolean isDeleted);
}
