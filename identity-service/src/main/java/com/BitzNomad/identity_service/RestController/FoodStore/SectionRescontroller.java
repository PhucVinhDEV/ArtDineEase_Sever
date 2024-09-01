package com.BitzNomad.identity_service.RestController.FoodStore;

import com.BitzNomad.identity_service.DtoReponese.ApiResponse;
import com.BitzNomad.identity_service.DtoReponese.CustomPageResponse;
import com.BitzNomad.identity_service.DtoReponese.SectionReponesesDTO;
import com.BitzNomad.identity_service.DtoRequest.SectionRequestDTO;
import com.BitzNomad.identity_service.Mapper.FoodStore.SectionMapper;
import com.BitzNomad.identity_service.Service.FoodStoreService.SectionService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sections")
@SecurityRequirement(name = "bearer-key")
public class SectionRescontroller {

    private final SectionService sectionService;
    private final SectionMapper sectionMapper;

    @Autowired
    public SectionRescontroller(SectionService sectionService, SectionMapper sectionMapper) {
        this.sectionService = sectionService;
        this.sectionMapper = sectionMapper;
    }

    @GetMapping
    public ApiResponse<CustomPageResponse<SectionReponesesDTO>> getAllSections(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "sort", defaultValue = "name,asc") String sort,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
        Sort sortOrder = Sort.by(Sort.Direction.fromString(direction), sort);
        Pageable pageable = PageRequest.of(page, size, sortOrder);
        return ApiResponse.<CustomPageResponse<SectionReponesesDTO>>builder()
                .message("getAllSections successfully")
                .status(200)
                .result(
                        sectionService.getSectionReponesesBySection(pageable)
                )
                .build();
    }

    @GetMapping("/Foodstore")
    public ApiResponse<List<SectionReponesesDTO>> getAllSectionsByFoodStore(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "sort", defaultValue = "id") String sort,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "foodstoreId") Long foodStoreID
    ) {
        Sort sortOrder = Sort.by(Sort.Direction.fromString(direction), sort);
        Pageable pageable = PageRequest.of(page, size, sortOrder);
        return ApiResponse.<List<SectionReponesesDTO>>builder()
                .message("getAllSections by"+foodStoreID+" successfully")
                .status(200)
                .result(
                        sectionService.getSectionReponesesByFoodStored(pageable,foodStoreID)
                )
                .build();
    }

    @PostMapping
    public ApiResponse<SectionReponesesDTO> createSection(SectionRequestDTO sectionRequestDTO){
        return ApiResponse.<SectionReponesesDTO>builder()
                .message("createSection successfully")
                .status(201)
                .result(
                        sectionService.save(sectionRequestDTO)
                )
                .build();
    }
    @DeleteMapping
    public ApiResponse<Void> deleteSection(Long sectionID){
        sectionService.deleteById(sectionID);
        return ApiResponse.<Void>builder()
                .message("deleteSection successfully")
                .status(204)
                .build();
    }
}
