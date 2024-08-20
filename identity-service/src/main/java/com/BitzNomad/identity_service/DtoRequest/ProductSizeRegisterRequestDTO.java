package com.BitzNomad.identity_service.DtoRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductSizeRegisterRequestDTO {
    Long id;
    String description;
    Double price;
    Long productId;
    Long sizeId;
    MultipartFile[] multipartFiles;
}
