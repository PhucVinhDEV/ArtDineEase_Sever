package com.BitzNomad.identity_service.DtoRequest;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AttributeRequestDTO {

    Long id;

    String AtrributeName;

    String AttributeValue;

    Long foodstoreId;
}
