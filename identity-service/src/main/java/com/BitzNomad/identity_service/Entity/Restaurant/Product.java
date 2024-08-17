package com.BitzNomad.identity_service.Entity.Restaurant;

import com.BitzNomad.identity_service.Entity.BaseEntity;
import com.BitzNomad.identity_service.Entity.Image.ImageOfProduct;
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
    @JoinColumn(name = "foodStore_id")
    FoodStore foodStore;

    @OneToMany(mappedBy = "product")
    Set<ProductSize> productSizes;

    @ManyToOne
    @JoinColumn(name = "CatagoryOfProduct_id")
    CatagoryOfProduct catagory;

    @OneToMany(mappedBy = "product")
    Set<ImageOfProduct> imageOfProducts;
}
