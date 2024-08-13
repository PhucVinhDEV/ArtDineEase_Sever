package com.BitzNomad.identity_service.DtoRequest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseImageDTO {
    private String url;
    private String cloudinaryPublicUrl;
    private String typeOfImg;
}
