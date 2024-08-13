package com.BitzNomad.identity_service.entity.Restaurant;

import com.BitzNomad.identity_service.entity.BaseEntity;
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
public class Section extends BaseEntity<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String SectionName;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)  // Ensures that every Table belongs to a Restaurant
    Restaurant restaurant;

    @OneToMany(mappedBy = "section")
    Set<MenuSection> menuSections;
}
