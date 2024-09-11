package com.example.BitzNomad.DTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserReponese {
    String id;
    String email;
    String firstName;
    String lastName;
    String phoneNumber;
}
