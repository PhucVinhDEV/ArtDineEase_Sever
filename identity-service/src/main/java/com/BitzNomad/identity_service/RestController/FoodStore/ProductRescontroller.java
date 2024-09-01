package com.BitzNomad.identity_service.RestController.FoodStore;

import com.BitzNomad.identity_service.DtoReponese.ApiResponse;
import com.BitzNomad.identity_service.DtoReponese.ProductResponeseDTO;
import com.BitzNomad.identity_service.DtoRequest.ProductRegisterRequestDTO;
import com.BitzNomad.identity_service.DtoRequest.ProductRequestDTO;
import com.BitzNomad.identity_service.Service.FoodStoreService.ProductService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/Product")
@SecurityRequirement(name = "bearer-key")
public class ProductRescontroller {

    @Autowired
    ProductService productService;

    @PostMapping
    public ApiResponse<ProductResponeseDTO> addProduct(@RequestBody ProductRequestDTO productRequestDTO) {
        return ApiResponse.<ProductResponeseDTO>builder()
                .status(201)
                .message("Created Product Successfully")
                .result(productService.save(productRequestDTO))
                .build();
    }

    @GetMapping
    public ApiResponse<Iterator<ProductResponeseDTO>> getProduct() {
        return ApiResponse.<Iterator<ProductResponeseDTO>>builder()
                .status(200)
                .message("Get All Products Successfully")
                .result(productService.findAll())
                .build();
    }

    @GetMapping("/ProductId")
    public ApiResponse<ProductResponeseDTO> getProductById(@RequestParam Long id) {
        return ApiResponse.<ProductResponeseDTO>builder()
                .status(200)
                .message("Get Product Successfully")
                .result(productService.findById(id))
                .build();
    }

    @GetMapping("/FoodStoreId")
    public ApiResponse<List<ProductResponeseDTO>> getProductByFoodStoreId(@RequestParam Long id) throws Exception {
        return ApiResponse.<List<ProductResponeseDTO>>builder()
                .status(200)
                .message("Get Product Successfully")
                .result(productService.GetAllProductsByFoodstoreID(id))
                .build();
    }

    @PostMapping("/Created")
    public ApiResponse<Void> createProduct(@ModelAttribute ProductRegisterRequestDTO productRequestDTO) throws Exception {
        productService.CreatedProduct(productRequestDTO);
        return ApiResponse.<Void>builder()
                .status(201)
                .message("Created Product Successfully")
                .build();
    }
}
