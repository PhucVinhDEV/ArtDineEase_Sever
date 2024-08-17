package com.BitzNomad.identity_service.DtoReponese;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class FoodStoreReponese {

    Long id;
    String name;
    String address;
    String description;
    List<ImageDTOReponese> imageDTOReponeseList;


}
