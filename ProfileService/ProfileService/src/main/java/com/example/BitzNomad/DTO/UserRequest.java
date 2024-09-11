package com.example.BitzNomad.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequest {

        @Email
        private String email;
        private String firstName;
        private String lastName;
        private String phoneNumber;
//    @DobConstraint(min = 2,message = "INVALID_DOB")
//    @NotNull
//    private LocalDate dob;

}
