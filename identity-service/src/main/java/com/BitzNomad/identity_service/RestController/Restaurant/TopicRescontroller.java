package com.BitzNomad.identity_service.RestController.Restaurant;

import com.BitzNomad.identity_service.DtoReponese.ApiResponse;
import com.BitzNomad.identity_service.DtoReponese.TopicReponese;
import com.BitzNomad.identity_service.DtoRequest.TopicRequestDTO;
import com.BitzNomad.identity_service.Entity.Restaurant.Topic;
import com.BitzNomad.identity_service.Service.RestaurantService.TopicService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;

@RestController
@RequestMapping("/Topic")
@SecurityRequirement(name = "bearer-key")
public class TopicRescontroller {
    @Autowired
    TopicService topicService;

    @PostMapping
    public ApiResponse<TopicReponese> CreateTopic(@RequestBody TopicRequestDTO topic) {
        return ApiResponse.<TopicReponese>builder()
                .status(200)
                .message("Create Topic successfully")
                .result(topicService.save(topic))
                .build();
    }

    @GetMapping("/Id")
    public ApiResponse<TopicReponese> GetTopic(@RequestParam Long id) {
        return ApiResponse.<TopicReponese>builder()
                .status(200)
                .message("Get Topic by id successfully")
                .result(topicService.findById(id))
                .build();
    }

    @GetMapping
    public ApiResponse<Iterator<TopicReponese>> GetAllTopics() {
        return ApiResponse.<Iterator<TopicReponese>>builder()
                .status(200)
                .message("Get All Topic successfully")
                .result(topicService.findAll())
                .build();
    }

    @DeleteMapping
    public ApiResponse<Void> DeleteTopic(@RequestParam Long id) {
        topicService.deleteById(id);
        return ApiResponse.<Void>builder()
                .status(200)
                .message("Get Topic by id successfully")
                .build();
    }

    @PutMapping
    public ApiResponse<TopicReponese> UpdateTopic(@RequestBody TopicRequestDTO topic) {
        return ApiResponse.<TopicReponese>builder()
                .status(200)
                .message("Update Topic successfully")
                .result(topicService.update(topic))
                .build();
    }
}
