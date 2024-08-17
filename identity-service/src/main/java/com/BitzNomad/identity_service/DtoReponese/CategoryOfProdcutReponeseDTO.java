package com.BitzNomad.identity_service.DtoReponese;

import com.BitzNomad.identity_service.Entity.Restaurant.Product;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.Set;

@Data
public class CategoryOfProdcutReponeseDTO {
    Long id;
    String name;
    String description;
    Set<ProductResponeseDTO> products;
}
