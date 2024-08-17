package com.BitzNomad.identity_service.Service.CloudiaryService.CloudImpl;

import com.BitzNomad.identity_service.DtoReponese.ImageDTOReponese;
import com.BitzNomad.identity_service.Entity.Image.ImageOfProduct;
import com.BitzNomad.identity_service.Mapper.ImageMapper;
import com.BitzNomad.identity_service.Respository.ImgRepository.ImageOfProductRepository;
import com.BitzNomad.identity_service.Respository.RestaurantRepository.ProductRepository;
import com.BitzNomad.identity_service.Service.CloudiaryService.CloudinaryService;
import com.BitzNomad.identity_service.Service.CloudiaryService.ImageOfProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class ImageOfProductImpl implements ImageOfProductService {

    @Autowired
    ImageOfProductRepository imageOfProductRepository;

    @Autowired
    ImageMapper imageMapper;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CloudinaryService cloudinaryService;
    @Override
    public Set<ImageDTOReponese> saveImageOfProduct(MultipartFile[] imageOfRestaurant,Long producttID, String typeofImage) throws Exception {
        Set<ImageDTOReponese> imageDTOReponses = new HashSet<>();
        for (MultipartFile file : imageOfRestaurant) {
          String uuid = java.util.UUID.randomUUID().toString();
          Map map =  cloudinaryService.uploadImage(file,uuid);
          ImageOfProduct img = new ImageOfProduct();
          img.setProduct(
                  productRepository.findById(producttID).orElseThrow(() -> new Exception("Restaurant Not Found") )
          );
          img.setUrl(map.get("secure_url").toString());
          img.setCloudiaryPuclicUrl(uuid);
          img.setTypeOfImg(typeofImage);
            imageDTOReponses.add(imageMapper.convertImgProductToImageDTOReponese( imageOfProductRepository.save(img)));
      }
        return imageDTOReponses;
    }
}
