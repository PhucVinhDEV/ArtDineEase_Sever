package com.BitzNomad.identity_service.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class BaseImage extends BaseEntity<String> {

    @Column(nullable = false)
    protected String url;

    @Column(nullable = false)
    protected String cloudiaryPuclicUrl;

    @Column(nullable = false)
    protected String TypeOfImg;
}
