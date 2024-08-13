package com.BitzNomad.identity_service.entity.Restaurant;

import com.BitzNomad.identity_service.entity.Auth.User;
import com.BitzNomad.identity_service.entity.BaseEntity;
import com.BitzNomad.identity_service.entity.Image.ImageOfRestaurant;
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
public class Restaurant extends BaseEntity<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    String address;

    String description;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    User owner;

    @OneToMany(mappedBy = "restaurant")
    Set<TableOfRestaurant> tables;

    @OneToMany(mappedBy = "restaurant")
    Set<Attribute> attributes;

    @OneToMany(mappedBy = "restaurant")
    Set<Section> sections;

    @OneToMany(mappedBy = "restaurant")
    Set<Product> products;

    @OneToMany(mappedBy = "restaurant")
    Set<ImageOfRestaurant> imageOfRestaurants;
}
