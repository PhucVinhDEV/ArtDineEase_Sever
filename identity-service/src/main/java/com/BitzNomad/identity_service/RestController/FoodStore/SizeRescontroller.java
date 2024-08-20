package com.BitzNomad.identity_service.RestController.FoodStore;

import com.BitzNomad.identity_service.DtoReponese.ApiResponse;
import com.BitzNomad.identity_service.DtoReponese.SizeReponeseDTO;
import com.BitzNomad.identity_service.DtoRequest.SizeRequestDTO;
import com.BitzNomad.identity_service.Service.FoodStoreService.SizeService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Size")
@SecurityRequirement(name = "bearer-key")
public class SizeRescontroller {
    @Autowired
    SizeService sizeService;

    @PostMapping
    public ApiResponse<SizeReponeseDTO> CreatedSize(@RequestBody SizeRequestDTO requestDTO) {
        return ApiResponse.<SizeReponeseDTO>builder()
                .message("Created size successfully")
                .status(201)
                .result(sizeService.save(requestDTO))
                .build();
    }

    @PutMapping
    public ApiResponse<SizeReponeseDTO> UpdatedSize(@RequestBody SizeRequestDTO requestDTO) {
        return ApiResponse.<SizeReponeseDTO>builder()
                .message("Updated size successfully")
                .status(201)
                .result(sizeService.update(requestDTO))
                .build();
    }
}
