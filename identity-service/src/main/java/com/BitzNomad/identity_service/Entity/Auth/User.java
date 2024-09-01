package com.BitzNomad.identity_service.Entity.Auth;

import com.BitzNomad.identity_service.Entity.BaseEntity;
import com.BitzNomad.identity_service.Entity.Restaurant.FoodStore;
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

    @Column(unique = true)
    String email;


    String password;

    String firstName;

    String phoneNumber;

    String lastName;

  // date of birth
    LocalDate dob;

    @ManyToMany
    Set<Role> roles;

    @OneToMany(mappedBy = "owner")
    Set<FoodStore> foodStores;
}
