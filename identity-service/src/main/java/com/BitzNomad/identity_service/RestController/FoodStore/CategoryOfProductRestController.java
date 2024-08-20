package com.BitzNomad.identity_service.RestController.FoodStore;

import com.BitzNomad.identity_service.DtoReponese.ApiResponse;
import com.BitzNomad.identity_service.DtoReponese.CategoryOfProdcutReponeseDTO;
import com.BitzNomad.identity_service.DtoRequest.CategoryOfProductRequestDTO;
import com.BitzNomad.identity_service.Service.FoodStoreService.CategoryOfProductService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;

@RestController
@RequestMapping("/CategoryOfProduct")
@SecurityRequirement(name = "bearer-key")
public class CategoryOfProductRestController {

    @Autowired
    CategoryOfProductService categoryOfProductService;

    @PostMapping
    public ApiResponse<CategoryOfProdcutReponeseDTO> CreatedCategoryOfProduct(@RequestBody CategoryOfProductRequestDTO categoryOfProductRequestDTO) {
        return ApiResponse.<CategoryOfProdcutReponeseDTO>builder()
                .status(201)
                .message("Category Of Product created successfully")
                .result(categoryOfProductService.save(categoryOfProductRequestDTO))
                .build();
    }

    @GetMapping
    public ApiResponse<Iterator<CategoryOfProdcutReponeseDTO>> getAllCategoryOfProducts() {
        return ApiResponse.<Iterator<CategoryOfProdcutReponeseDTO>>builder()
                .status(200)
                .message("All Category Of Products successfully")
                .result(
                        categoryOfProductService.findAll()
                )
                .build();
    }
    @PutMapping
    public ApiResponse<CategoryOfProdcutReponeseDTO> UpdatedCategoryOfProduct(@RequestBody CategoryOfProductRequestDTO categoryOfProductRequestDTO) {

        return ApiResponse.<CategoryOfProdcutReponeseDTO>builder()
                .status(200)
                .message("Category Of Product updated successfully")
                .result(categoryOfProductService.update(categoryOfProductRequestDTO))
                .build();
    }

    @GetMapping("/ID")
    public ApiResponse<CategoryOfProdcutReponeseDTO> getCategoryOfProductById(@RequestParam Long id) {
        return ApiResponse.<CategoryOfProdcutReponeseDTO>builder()
                .status(200)
                .message("Category Of Product successfully")
                .result(categoryOfProductService.findById(id))
                .build();
    }
}
