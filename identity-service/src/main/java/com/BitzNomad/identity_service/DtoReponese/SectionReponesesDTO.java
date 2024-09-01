package com.BitzNomad.identity_service.DtoReponese;

import lombok.Data;

import java.util.Set;

@Data
public class SectionReponesesDTO {
    Long id;

    String SectionName;

    String FoodstoreName;

    CustomPageResponse<ProductSizeReponeseDTO> productResponeseDTOSet;
}
