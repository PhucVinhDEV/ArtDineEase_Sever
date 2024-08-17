package com.BitzNomad.identity_service.DtoReponese;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ImageDTOReponese {
    String url;
    String cloudinaryPublicUrl;
    String typeOfImg;
}
