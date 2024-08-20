package com.BitzNomad.identity_service.RestController.FoodStore;

import com.BitzNomad.identity_service.DtoReponese.ApiResponse;
import com.BitzNomad.identity_service.DtoRequest.ProductSizeRegisterRequestDTO;
import com.BitzNomad.identity_service.Service.FoodStoreService.ProductSizeService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ProductSize")
@SecurityRequirement(name = "bearer-key")
public class ProductSizeRescontroller {

    @Autowired
    ProductSizeService productSizeService;

    @PostMapping
    public ApiResponse<Void> CreatedProducSize(@ModelAttribute ProductSizeRegisterRequestDTO productSizeRegisterRequestDTO) throws Exception {
        productSizeService.CreatedProductSize(productSizeRegisterRequestDTO);
        return ApiResponse.<Void>builder()
                .message("Created product size successfully")
                .status(200)
                .build();
    }
}
