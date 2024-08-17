package com.BitzNomad.identity_service.RestController.Image;

import com.BitzNomad.identity_service.DtoReponese.ApiResponse;
import com.BitzNomad.identity_service.DtoReponese.ImageDTOReponese;
import com.BitzNomad.identity_service.Service.CloudiaryService.CloudinaryService;
import com.BitzNomad.identity_service.Service.CloudiaryService.ImageOfFoodStoreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

@RestController
@RequestMapping("/ImageFoodStore")
public class ImageFoodStoreController {

    @Autowired
    CloudinaryService cloudinaryService;

    @Autowired
    ImageOfFoodStoreService imageOfFoodStoreService;

    @PostMapping
    @Operation(summary = "Upload an image", description = "Uploads an image file to Cloudinary and returns the upload result. (Test PostMan nha)")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Image uploaded successfully", content = @Content(mediaType = "application/json")),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = "application/json"))
    })
    public ApiResponse<Set<ImageDTOReponese>> uploadImage(@RequestParam("file") MultipartFile[] file, @RequestParam("restaurantID") Long restaurantID,
                                                          @RequestParam("typeOfImg") String typeOfImg) throws Exception {

        return ApiResponse.<Set<ImageDTOReponese>>builder()
                .status(201)
                .result(imageOfFoodStoreService.saveImageOfFoodStore(file,restaurantID,typeOfImg))
                .build();
    }

    @DeleteMapping
    @Operation(summary = "Delete  image", description = "Delete an image file to Cloudinary and returns the Delete result")
    public ApiResponse<Boolean> deleteImage(@RequestParam("cloudinaryPublicId") String id) throws Exception {
        return  ApiResponse.<Boolean>builder()
                .status(202)
                .message("Deleted image successfully")
                .result(cloudinaryService.deleteImage(id))
                .build();
    }
}
