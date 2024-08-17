package com.BitzNomad.identity_service.Entity.Restaurant;

import jakarta.persistence.*;

@Entity
public class TopicFoodStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String Descreption;

    @ManyToOne
    @JoinColumn(name = "foodStore_id", nullable = false)
    FoodStore foodStore;

    @ManyToOne
    @JoinColumn(name = "topic_id", nullable = false)
    Topic topic;
}
