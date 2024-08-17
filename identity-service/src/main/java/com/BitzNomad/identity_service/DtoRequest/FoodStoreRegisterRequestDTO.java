package com.BitzNomad.identity_service.DtoRequest;


import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FoodStoreRegisterRequestDTO {

    String name;
    String address;
    String description;
    String phoneNumber;
    MultipartFile[] multipartFiles;
    String typeOfImage;
    String email;
}
