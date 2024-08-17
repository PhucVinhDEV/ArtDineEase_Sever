package com.BitzNomad.identity_service.Entity.Restaurant;

import com.BitzNomad.identity_service.Entity.Auth.User;
import com.BitzNomad.identity_service.Entity.BaseEntity;
import com.BitzNomad.identity_service.Entity.Image.ImageOfFoodStore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FoodStore extends BaseEntity<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    String address;

    String description;

    String phoneNumber;

    boolean statusOfRestaurant;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    User owner;

    @OneToMany(mappedBy = "foodStore")
    Set<TableOfFoodStore> tables;

    @OneToMany(mappedBy = "foodStore")
    Set<Attribute> attributes;

    @OneToMany(mappedBy = "foodStore")
    Set<Section> sections;

    @OneToMany(mappedBy = "foodStore")
    Set<Product> products;

    @OneToMany(mappedBy = "foodStore")
    Set<ImageOfFoodStore> imageOfFoodStores;
}
