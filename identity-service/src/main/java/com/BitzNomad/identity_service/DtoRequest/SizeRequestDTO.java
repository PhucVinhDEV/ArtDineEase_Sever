package com.BitzNomad.identity_service.DtoRequest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SizeRequestDTO {
    Long id;
    @Column(unique = true, nullable = false)
    String name;
    String description;
}
