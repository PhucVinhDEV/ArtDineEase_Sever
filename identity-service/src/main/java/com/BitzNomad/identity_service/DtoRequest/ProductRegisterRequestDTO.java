package com.BitzNomad.identity_service.DtoRequest;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRegisterRequestDTO {
    String name;
    String description;
    Long id;
    Long foodStoreId;
    Long categoryId;
    MultipartFile[] multipartFiles;

}
