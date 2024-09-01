package com.BitzNomad.identity_service.Service.CloudiaryService.CloudImpl;

import com.BitzNomad.identity_service.DtoReponese.ImageDTOReponese;
import com.BitzNomad.identity_service.Entity.Image.Banner;
import com.BitzNomad.identity_service.Entity.Image.ImageOfProduct;
import com.BitzNomad.identity_service.Entity.Restaurant.CategoryOfFoodStore;
import com.BitzNomad.identity_service.Mapper.ImageMapper;
import com.BitzNomad.identity_service.Respository.ImgRepository.BannerRepository;
import com.BitzNomad.identity_service.Respository.RestaurantRepository.CategoryOfFoodStoreRepository;
import com.BitzNomad.identity_service.Service.CloudiaryService.BannerService;
import com.BitzNomad.identity_service.Service.CloudiaryService.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class BannerImpl implements BannerService {

    @Autowired
    CloudinaryService cloudinaryService;

    @Autowired
    BannerRepository bannerRepository;

    @Autowired
    ImageMapper imageMapper;

    @Autowired
    CategoryOfFoodStoreRepository categoryOfFoodStoreRepository;

    @Override
    public Set<ImageDTOReponese> saveBanner(MultipartFile[] imageOfBanner, String typeofImage) throws Exception {
        Set<ImageDTOReponese> imageDTOReponses = new HashSet<>();
        for (MultipartFile file : imageOfBanner) {
            String uuid = java.util.UUID.randomUUID().toString();
            Map map =  cloudinaryService.uploadImage(file,uuid);
            Banner img = new Banner();
            img.setUrl(map.get("secure_url").toString());
            img.setCloudiaryPuclicUrl(uuid);
            img.setTypeOfImg(typeofImage);
            imageDTOReponses.add(imageMapper.convertBanerToImageDTOReponese( bannerRepository.save(img)));
        }
        return imageDTOReponses;
    }

    @Override
    public Set<ImageDTOReponese> saveImgCategory(MultipartFile[] imageOfBanner, Long categoryId) throws Exception {
        CategoryOfFoodStore categoryOfFoodStore = categoryOfFoodStoreRepository.findById(categoryId).orElseThrow(
                () -> new Exception("Category Not Found")
        );
        Set<ImageDTOReponese> imageDTOReponses = new HashSet<>();
        for (MultipartFile file : imageOfBanner) {String uuid = java.util.UUID.randomUUID().toString();
            Map map =  cloudinaryService.uploadImage(file,uuid);
            Banner img = new Banner();
            img.setUrl(map.get("secure_url").toString());
            img.setCloudiaryPuclicUrl(uuid);
            img.setTypeOfImg(categoryOfFoodStore.getName() + categoryOfFoodStore.getId());
            imageDTOReponses.add(imageMapper.convertBanerToImageDTOReponese( bannerRepository.save(img)));
        }
        return imageDTOReponses;
    }
}
