package com.BitzNomad.identity_service.RestController.FoodStore;


import com.BitzNomad.identity_service.DtoReponese.ApiResponse;
import com.BitzNomad.identity_service.DtoReponese.ImageDTOReponese;
import com.BitzNomad.identity_service.Service.CloudiaryService.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

@RestController
@RequestMapping("/ImgBanner")
public class BannerRescontroller {

    @Autowired
    BannerService bannerService;


    @PostMapping
    public ApiResponse<Set<ImageDTOReponese>> UploadImgBanner(@RequestParam("file") MultipartFile[] files) throws Exception {
        Set<ImageDTOReponese> savedBanners = bannerService.saveBanner(files, "Banner");
        return ApiResponse.<Set<ImageDTOReponese>>builder()
                .status(201)
                .message("Upload image successfully")
                .result(savedBanners)
                .build();
    }

    @PostMapping("/Catagory")
    public ApiResponse<Set<ImageDTOReponese>> UploadImgCategory(@RequestParam("file") MultipartFile[] file,
                                                                @RequestParam("id")Long categoryid) throws Exception {
        return ApiResponse.<Set<ImageDTOReponese>>builder()
                .status(201)
                .message("Upload image successfully")
                .result(bannerService.saveImgCategory(file,categoryid))
                .build();
    }
}
