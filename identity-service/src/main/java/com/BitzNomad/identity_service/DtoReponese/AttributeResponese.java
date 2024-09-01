package com.BitzNomad.identity_service.DtoReponese;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AttributeResponese {
    Long id;
    String AtrributeName;
    String AttributeValue;
}
