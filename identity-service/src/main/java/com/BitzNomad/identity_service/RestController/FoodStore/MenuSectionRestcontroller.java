package com.BitzNomad.identity_service.RestController.FoodStore;

import com.BitzNomad.identity_service.DtoReponese.ApiResponse;
import com.BitzNomad.identity_service.DtoRequest.MenuSectionRequest;
import com.BitzNomad.identity_service.Entity.Restaurant.MenuSection;
import com.BitzNomad.identity_service.Service.FoodStoreService.MenuSectionService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/MenuSection")
@SecurityRequirement(name = "bearer-key")
public class MenuSectionRestcontroller {

    @Autowired
    MenuSectionService menuSectionService;

    @PostMapping()
    public ApiResponse<Void> createMenuSection(@RequestBody MenuSectionRequest menuSectionRequest) {
        menuSectionService.Created(menuSectionRequest);
        return ApiResponse.<Void>builder()
                .message("Created Menu Section")
                .status(201)

                .build();
    }

    // API để cập nhật MenuSection
    @PutMapping("/update")
    public ApiResponse<MenuSection> updateMenuSection(@RequestBody MenuSectionRequest menuSectionRequest) {
        return ApiResponse.<MenuSection>builder()
                .message("Updated Menu Section")
                .status(200)
                .result(menuSectionService.Updated(menuSectionRequest))
                .build();
    }
    // API để thay đổi trạng thái MenuSection
    @PatchMapping("/change-status/{id}")
    public ApiResponse<Void> changeMenuSectionStatus(@PathVariable("id") Long menuSectionId) {
        menuSectionService.ChangeStatus(menuSectionId);
        return ApiResponse.<Void>builder()
                .message("Changed Menu Section Status")
                .status(204)
                .build();
    }
}
