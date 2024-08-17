package com.BitzNomad.identity_service.Entity.Restaurant;

import com.BitzNomad.identity_service.Entity.Image.ImageOfProduct;
import com.BitzNomad.identity_service.Entity.Image.ImageOfProductSize;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.Set;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class ProductSize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String description;

    BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;

    @ManyToOne
    @JoinColumn(name = "size_id")
    Size size;

    @OneToMany(mappedBy = "productSize")
    Set<MenuSection> menuSections;

    @OneToMany(mappedBy = "productSize")
    Set<OrderDetail> orderDetails;

    @OneToMany(mappedBy = "productSize")
    Set<ImageOfProductSize> imageOfProductSizes;
}
