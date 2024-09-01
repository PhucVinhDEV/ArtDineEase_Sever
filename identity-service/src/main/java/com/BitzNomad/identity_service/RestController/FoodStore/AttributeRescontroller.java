package com.BitzNomad.identity_service.RestController.FoodStore;

import com.BitzNomad.identity_service.DtoReponese.ApiResponse;
import com.BitzNomad.identity_service.DtoReponese.AttributeResponese;
import com.BitzNomad.identity_service.DtoRequest.AttributeRequestDTO;

import com.BitzNomad.identity_service.Service.FoodStoreService.AttributeService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Attribute")
@SecurityRequirement(name = "bearer-key")
public class AttributeRescontroller {

    @Autowired
    AttributeService attributeService;

    @PostMapping
    public ApiResponse<AttributeResponese> saveAtriibuteByFoodstore(@RequestBody AttributeRequestDTO attribute) {
        return ApiResponse.<AttributeResponese>builder()
                .message("Created Attribute Successfully")
                .status(201)
                .result(attributeService.save(attribute))
                .build();
    }

    @GetMapping
    public ApiResponse<List<AttributeResponese>> getAllAttributesByFoodStore(@RequestParam("foodstoreid") Long foodstoreid) {
        return ApiResponse.<List<AttributeResponese>>builder()
                .message("Get All Attributes Successfully")
                .status(200)
                .result(attributeService.getAttributeByfoodstoreId(foodstoreid))
                .build();
    }

}
