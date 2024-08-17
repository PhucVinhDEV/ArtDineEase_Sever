package com.BitzNomad.identity_service.DtoReponese;

import com.BitzNomad.identity_service.Entity.Restaurant.Product;
import com.BitzNomad.identity_service.Entity.Restaurant.Size;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductSizeReponeseDTO {
    long id;

    String description;

    BigDecimal price;

    String productID;

    String productName;

    String sizeName;

}
