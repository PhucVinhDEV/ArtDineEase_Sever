package com.BitzNomad.identity_service.DtoReponese;

import com.BitzNomad.identity_service.DtoRequest.BaseDTO;
import com.BitzNomad.identity_service.Entity.Restaurant.ProductSize;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SizeReponeseDTO extends BaseDTO<String> {
    String name;
    String description;
    Set<ProductSizeReponeseDTO> productSizeReponeseDTOSet;
}
