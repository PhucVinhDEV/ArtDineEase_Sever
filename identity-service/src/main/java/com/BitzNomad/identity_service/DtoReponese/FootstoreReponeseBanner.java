package com.BitzNomad.identity_service.DtoReponese;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FootstoreReponeseBanner {
    Long id;
    String name;
    String address;
    String description;
    ImageDTOReponese imageDTOReponese;
}
