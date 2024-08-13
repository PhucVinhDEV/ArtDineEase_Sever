package com.BitzNomad.identity_service.RestController.Image;

import com.BitzNomad.identity_service.DtoReponese.ApiResponse;
import com.BitzNomad.identity_service.Service.CloudService.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/Image")
public class ImageResController {

    @Autowired
    CloudinaryService cloudinaryService;

    @PostMapping
    public ResponseEntity<Map> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            // Tạo UUID cho hình ảnh
            String uuid = java.util.UUID.randomUUID().toString();

            // Upload hình ảnh lên Cloudinary
            Map uploadResult = cloudinaryService.uploadImage(file, uuid);

            return new ResponseEntity<>(uploadResult, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("error", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping
    public ApiResponse<Boolean> deleteImage(@RequestParam("cloudinaryPublicId") String id) throws Exception {
        return  ApiResponse.<Boolean>builder()
                .status(202)
                .message("Deleted image successfully")
                .result(cloudinaryService.deleteImage(id))
                .build();
    }
}
