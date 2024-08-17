package com.BitzNomad.identity_service.DtoRequest;

import com.BitzNomad.identity_service.Validator.DobConstraint;
import com.BitzNomad.identity_service.Validator.NameConstrant;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import java.time.LocalDate;

@Data
public class UserCreateRequest {

    @Column(unique = true)
    @Email
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "PASSWORD_INVALID")
    private String password;

    private String firstName;
    private String lastName;

    private String phoneNumber;
//    @DobConstraint(min = 2,message = "INVALID_DOB")
//    @NotNull
//    private LocalDate dob;
}
