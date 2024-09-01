package com.BitzNomad.identity_service.DtoReponese;

import lombok.Data;

import java.util.Set;

@Data
public class CategoryOfFoodStoreReponeseDTO {
    Long id;
    String name;
    String description;
    Set<FoodStoreReponese> foodStoreReponeseSet;
    ImageDTOReponese imageDTOReponese;
}
