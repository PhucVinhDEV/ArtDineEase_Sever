package com.BitzNomad.identity_service.Entity.Restaurant;

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
public class MenuSection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    String title;
    String description;

    @ManyToOne
    @JoinColumn(name = "section_id" , nullable = false)
    Section section;

    @ManyToOne
    @JoinColumn(name = "productsize_id" , nullable = false)
    ProductSize productSize;
}
