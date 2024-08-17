package com.BitzNomad.identity_service.Entity.Image;

import com.BitzNomad.identity_service.Entity.BaseImage;
import com.BitzNomad.identity_service.Entity.Restaurant.Product;
import com.BitzNomad.identity_service.Entity.Restaurant.ProductSize;
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
public class ImageOfProductSize extends BaseImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "productSize_id")
    ProductSize productSize;
}
