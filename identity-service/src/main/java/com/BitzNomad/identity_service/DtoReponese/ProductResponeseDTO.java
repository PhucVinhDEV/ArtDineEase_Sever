package com.BitzNomad.identity_service.DtoReponese;

import lombok.Data;

import java.util.Set;

@Data
public class ProductResponeseDTO {

    Long id;

    String name;

    String description;

    String category;

    Set<ImageDTOReponese> imageDTOReponeseSet;
}
