package com.BitzNomad.identity_service.Entity.Restaurant;

import com.BitzNomad.identity_service.Entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class TopicFoodStore extends BaseEntity<String> {
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
