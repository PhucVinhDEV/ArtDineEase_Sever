package com.BitzNomad.identity_service.Entity.Image;

import com.BitzNomad.identity_service.Entity.BaseImage;
import com.BitzNomad.identity_service.Entity.Restaurant.FoodStore;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ImageOfFoodStore extends BaseImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "FoodStore_id")
    FoodStore foodStore;
}
