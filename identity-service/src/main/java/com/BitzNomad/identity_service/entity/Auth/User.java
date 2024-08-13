package com.BitzNomad.identity_service.entity.Auth;

import com.BitzNomad.identity_service.entity.BaseEntity;
import com.BitzNomad.identity_service.entity.Restaurant.Restaurant;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User extends BaseEntity<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    String username;


    String password;


    String firstName;


    String lastName;

  // date of birth
    LocalDate dob;

    @ManyToMany
    Set<Role> roles;

    @OneToMany(mappedBy = "owner")
    Set<Restaurant> restaurants;
}
