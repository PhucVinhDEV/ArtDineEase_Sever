package com.BitzNomad.identity_service.RestController.Restaurant;

import com.BitzNomad.identity_service.DtoReponese.ApiResponse;
import com.BitzNomad.identity_service.DtoRequest.TopicFoodStoreRequest;
import com.BitzNomad.identity_service.Entity.Restaurant.TopicFoodStore;
import com.BitzNomad.identity_service.Service.RestaurantService.TopicFoodStoreService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/TopicFoodStore")
@SecurityRequirement(name = "bearer-key")
public class TopicFoodStoreController {
    @Autowired
    TopicFoodStoreService topicFoodStoreService;

    @PostMapping
    public ApiResponse<Void> createTopicFoodStore(@RequestBody TopicFoodStoreRequest requestDTO) {
        topicFoodStoreService.CreateTopicFoodStore(requestDTO);
        return ApiResponse.<Void>builder()
                .message("Created TopicFoodStore successfully")
                .status(201)
                .build();
    }

    @PutMapping
    public ApiResponse<TopicFoodStore> updateTopicFoodStore(@RequestBody TopicFoodStoreRequest requestDTO) {
        TopicFoodStore updatedTopicFoodStore = topicFoodStoreService.updateTopicFoodStore(requestDTO);
        return ApiResponse.<TopicFoodStore>builder()
                .message("Updated TopicFoodStore successfully")
                .status(200)
                .result(updatedTopicFoodStore)
                .build();
    }

    @DeleteMapping
    public ApiResponse<Void> deleteTopicFoodStore(@RequestParam Long topicId, @RequestParam Long foodStoreId) {
        topicFoodStoreService.DeleteTopicFoodStore(topicId, foodStoreId);
        return ApiResponse.<Void>builder()
                .message("Deleted TopicFoodStore successfully")
                .status(200)
                .build();
    }
}
