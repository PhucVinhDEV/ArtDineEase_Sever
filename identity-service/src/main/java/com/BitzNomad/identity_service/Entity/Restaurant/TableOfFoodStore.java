package com.BitzNomad.identity_service.Entity.Restaurant;

import com.BitzNomad.identity_service.Entity.BaseEntity;
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
public class TableOfFoodStore extends BaseEntity<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    @ManyToOne
    @JoinColumn(name = "foodStore_id", nullable = false)  // Ensures that every Table belongs to a Restaurant
    FoodStore foodStore;

    @OneToMany(mappedBy = "tables")
    Set<Orders> orders;
}
