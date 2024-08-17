package com.BitzNomad.identity_service.RestController.Restaurant;

import com.BitzNomad.identity_service.DtoReponese.ApiResponse;
import com.BitzNomad.identity_service.DtoReponese.FoodStoreReponese;
import com.BitzNomad.identity_service.DtoRequest.FoodStoreRegisterRequestDTO;
import com.BitzNomad.identity_service.Mapper.Restaurant.FoodStoreMapper;
import com.BitzNomad.identity_service.Service.RestaurantService.FoodStoreService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;

@RestController
@RequestMapping("/FoodStore")
@SecurityRequirement(name = "bearer-key")
public class FoodStoreController {

    @Autowired
    FoodStoreService foodStoreService;

    @Autowired
    FoodStoreMapper foodStoreMapper;

    @PostMapping("/Send-Requset")
    public ApiResponse sentRequest(@RequestBody FoodStoreRegisterRequestDTO foodStoreRegisterRequestDTO) throws Exception {
        foodStoreService.SendRequestCreatedRestaurant(foodStoreRegisterRequestDTO);
        return ApiResponse.builder()
                .message("Send Restaurant Successfully")
                .status(201)
                .build();
    }

    @PostMapping
    public ApiResponse<FoodStoreReponese> saveRestaurant(@RequestBody FoodStoreRegisterRequestDTO foodStoreRegisterRequestDTO) throws Exception {
        var foodStore = foodStoreMapper.convertFoodStoreRequestToFoodStore(foodStoreRegisterRequestDTO);
        var foodStoreReponeses = foodStoreService.save(foodStore);
        return ApiResponse.<FoodStoreReponese> builder()
               .status(201)
               .message("Save Restaurant Successfully")
               .result(foodStoreReponeses)
               .build();
    }

    @GetMapping
    public ApiResponse<Iterator<FoodStoreReponese>> getRestaurant() throws Exception {
        return ApiResponse.<Iterator<FoodStoreReponese>>builder()
                .status(201)
                .message("Get Restaurant Successfully")
                .result(foodStoreService.findAll())
                .build();
    }
}
