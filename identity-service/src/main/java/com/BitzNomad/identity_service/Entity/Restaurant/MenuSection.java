package com.BitzNomad.identity_service.Entity.Restaurant;

import com.BitzNomad.identity_service.Entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class MenuSection extends BaseEntity<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;


    @ManyToOne
    @JoinColumn(name = "section_id" , nullable = false)
    Section section;

    @ManyToOne
    @JoinColumn(name = "productsize_id" , nullable = false)
    ProductSize productSize;
}
