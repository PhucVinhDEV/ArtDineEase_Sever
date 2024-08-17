package com.BitzNomad.identity_service.DtoRequest;

import com.BitzNomad.identity_service.Entity.Restaurant.Product;
import com.BitzNomad.identity_service.Entity.Restaurant.Size;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductSizeRequestDTO {

    Long productId;

    Long sizeid;

    String description;

    BigDecimal price;

}
