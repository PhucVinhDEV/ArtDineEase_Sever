package com.BitzNomad.identity_service.Service.CloudiaryService.CloudImpl;

import com.BitzNomad.identity_service.DtoReponese.ImageDTOReponese;
import com.BitzNomad.identity_service.Entity.Image.ImageOfFoodStore;
import com.BitzNomad.identity_service.Mapper.ImageMapper;
import com.BitzNomad.identity_service.Respository.ImgRepository.ImageOfFoodStoreRepository;
import com.BitzNomad.identity_service.Respository.RestaurantRepository.FoodStoreRepository;
import com.BitzNomad.identity_service.Service.CloudiaryService.CloudinaryService;
import com.BitzNomad.identity_service.Service.CloudiaryService.ImageOfFoodStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class ImageOfRestaurantImpl implements ImageOfFoodStoreService {

    @Autowired
    ImageOfFoodStoreRepository imageOfFoodStoreRepository;

    @Autowired
    ImageMapper imageMapper;

    @Autowired
    FoodStoreRepository foodStoreRepository;

    @Autowired
    CloudinaryService cloudinaryService;
    @Override
    public Set<ImageDTOReponese> saveImageOfFoodStore(MultipartFile[] imageOfRestaurant,Long restaurantID, String typeofImage) throws Exception {
        Set<ImageDTOReponese> imageDTOReponses = new HashSet<>();
        for (MultipartFile file : imageOfRestaurant) {
          String uuid = java.util.UUID.randomUUID().toString();
          Map map =  cloudinaryService.uploadImage(file,uuid);
          ImageOfFoodStore img = new ImageOfFoodStore();
          img.setFoodStore(
                  foodStoreRepository.findById(restaurantID).orElseThrow(() -> new Exception("Restaurant Not Found") )
          );
          img.setUrl(map.get("secure_url").toString());
          img.setCloudiaryPuclicUrl(uuid);
          img.setTypeOfImg(typeofImage);
            imageDTOReponses.add(imageMapper.convertImageOfRestaurantToImageDTOReponese( imageOfFoodStoreRepository.save(img)));
      }
        return imageDTOReponses;
    }
}
