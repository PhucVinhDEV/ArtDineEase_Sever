package com.BitzNomad.identity_service.Service.CloudiaryService;


import com.BitzNomad.identity_service.DtoReponese.ImageDTOReponese;

import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

public interface ImageOfRestaurantService {
    Set<ImageDTOReponese> saveImageOfRestaurant(MultipartFile[] imageOfRestaurant, Long restaurantID, String typeofImage) throws Exception;
}
