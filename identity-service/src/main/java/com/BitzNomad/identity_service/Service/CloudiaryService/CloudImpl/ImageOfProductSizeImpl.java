package com.BitzNomad.identity_service.Service.CloudiaryService.CloudImpl;

import com.BitzNomad.identity_service.DtoReponese.ImageDTOReponese;
import com.BitzNomad.identity_service.Entity.Image.ImageOfFoodStore;
import com.BitzNomad.identity_service.Entity.Image.ImageOfProductSize;
import com.BitzNomad.identity_service.Mapper.ImageMapper;
import com.BitzNomad.identity_service.Respository.ImgRepository.ImageOfProductSizeRepository;
import com.BitzNomad.identity_service.Respository.RestaurantRepository.ProductSizeRepository;
import com.BitzNomad.identity_service.Service.CloudiaryService.CloudinaryService;
import com.BitzNomad.identity_service.Service.CloudiaryService.ImageOfProductSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class ImageOfProductSizeImpl implements ImageOfProductSizeService {
    @Autowired
    CloudinaryService cloudinaryService;

    @Autowired
    ImageMapper imageMapper;

    @Autowired
    ImageOfProductSizeRepository imageOfProductSizeRepository;
    @Autowired
    ProductSizeRepository productSizeRepository;

    @Override
    public Set<ImageDTOReponese> saveImageOfProductSize(MultipartFile[] imageOfProductSize, Long ProductSizeID, String typeofImage) throws Exception {
        Set<ImageDTOReponese> imageDTOReponses = new HashSet<>();
        for (MultipartFile file : imageOfProductSize) {
            String uuid = java.util.UUID.randomUUID().toString();
            Map map =  cloudinaryService.uploadImage(file,uuid);
            ImageOfProductSize img = new ImageOfProductSize();
            img.setProductSize(
                    productSizeRepository.findById(ProductSizeID).orElseThrow(() -> new Exception("Restaurant Not Found") )
            );
            img.setUrl(map.get("secure_url").toString());
            img.setCloudiaryPuclicUrl(uuid);
            img.setTypeOfImg(typeofImage);
            imageDTOReponses.add(imageMapper.convertImageProductSizeToImageDTOReponese( imageOfProductSizeRepository.save(img)));
        }
        return imageDTOReponses;
    }
}
