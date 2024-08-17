package com.BitzNomad.identity_service.Mapper;

import com.BitzNomad.identity_service.DtoReponese.ImageDTOReponese;
import com.BitzNomad.identity_service.Entity.Image.Banner;
import com.BitzNomad.identity_service.Entity.Image.ImageOfFoodStore;
import com.BitzNomad.identity_service.Entity.Image.ImageOfProduct;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ImageMapper {
    @Autowired
    ModelMapper modelMapper;

//    public ImageOfRestaurant convertImageToImageOfRestaurant(ImageOfRestaurant imageOfRestaurant) {
//
//    };

    public ImageDTOReponese convertImageOfRestaurantToImageDTOReponese(ImageOfFoodStore imageOfRestaurant) {
      return  modelMapper.map(imageOfRestaurant, ImageDTOReponese.class);
    }

    public ImageDTOReponese convertImgProductToImageDTOReponese(ImageOfProduct imageOfProduct) {
        return modelMapper.map(imageOfProduct, ImageDTOReponese.class);
    }

    public ImageDTOReponese convertBanerToImageDTOReponese(Banner banner) {
        return modelMapper.map(banner, ImageDTOReponese.class);
    }
}
