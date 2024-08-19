package com.BitzNomad.identity_service.RestController.Restaurant;

import com.BitzNomad.identity_service.DtoReponese.ApiResponse;
import com.BitzNomad.identity_service.DtoReponese.CategoryOfFoodStoreReponeseDTO;
import com.BitzNomad.identity_service.DtoRequest.CategoryOfFoodStoreRequestDTO;
import com.BitzNomad.identity_service.Service.RestaurantService.CategoryOfFoodStoreService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;

@RestController
@RequestMapping("/CategoryOfFoodStore")
@SecurityRequirement(name = "bearer-key")
public class CategoryOfFoodStoreRestcontroller {

    @Autowired
    CategoryOfFoodStoreService categoryOfFoodStoreService;

    @PostMapping
    public ApiResponse<CategoryOfFoodStoreReponeseDTO> addCategoryOfFoodStore(@RequestBody CategoryOfFoodStoreRequestDTO categoryOfFoodStoreRequestDTO) {
        return ApiResponse.<CategoryOfFoodStoreReponeseDTO>builder()
                .status(200)
                .message("Category Of Food Store Added")
                .result(categoryOfFoodStoreService.save(categoryOfFoodStoreRequestDTO))
                .build();
    }

    @GetMapping
    public ApiResponse<Iterator<CategoryOfFoodStoreReponeseDTO>> getCategoryOfFoodStore() {
        return ApiResponse.<Iterator<CategoryOfFoodStoreReponeseDTO>>builder()
                .status(200)
                .message("Category Of Food Store List")
                .result(categoryOfFoodStoreService.findAll())
                .build();
    }

    @PutMapping
    public ApiResponse<CategoryOfFoodStoreReponeseDTO> UpdateCategoryOfFoodStore(@RequestBody CategoryOfFoodStoreRequestDTO categoryOfFoodStoreRequestDTO) {
        return ApiResponse.<CategoryOfFoodStoreReponeseDTO>builder()
                .status(200)
                .message("Category Of Food Store Updated")
                .result(categoryOfFoodStoreService.update(categoryOfFoodStoreRequestDTO))
                .build();
    }

    @DeleteMapping
    public ApiResponse<Void> DeletedCategory(@RequestParam Long id){
        categoryOfFoodStoreService.deleteById(id);
        return ApiResponse.<Void>builder()
                .status(204)
                .message("Category Of Food Store Deleted")
                .build();
    }

    @GetMapping("/Id")
    public ApiResponse<CategoryOfFoodStoreReponeseDTO> getCategoryOfFoodStoreById(@RequestParam Long id) {
        return ApiResponse.<CategoryOfFoodStoreReponeseDTO>builder()
                .status(200)
                .message("Category Of Food Store ById")
                .result(categoryOfFoodStoreService.findById(id))
                .build();
    }
}
