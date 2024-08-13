package com.BitzNomad.identity_service.entity.Restaurant;

import com.BitzNomad.identity_service.entity.BaseEntity;
import com.BitzNomad.identity_service.entity.Image.ImageOfProduct;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Product extends BaseEntity<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    String description;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    Restaurant restaurant;

    @OneToMany(mappedBy = "product")
    Set<ProductSize> productSizes;

    @ManyToOne
    @JoinColumn(name = "catagory_id")
    Catagory catagory;

    @OneToMany(mappedBy = "product")
    Set<ImageOfProduct> imageOfProducts;
}
