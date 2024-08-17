package com.BitzNomad.identity_service.Entity.Restaurant;

import com.BitzNomad.identity_service.Entity.BaseEntity;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Topic extends BaseEntity<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(unique = true, nullable = false)
    String name;

    @OneToMany(mappedBy = "topic")
    Set<TopicFoodStore> topicFoodStores;
}
