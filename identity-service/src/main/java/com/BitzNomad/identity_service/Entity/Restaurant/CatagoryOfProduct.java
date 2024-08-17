package com.BitzNomad.identity_service.Entity.Restaurant;

import com.BitzNomad.identity_service.Entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class CatagoryOfProduct extends BaseEntity<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String description;

    @OneToMany(mappedBy = "catagory")
    Set<Product> products;

}
