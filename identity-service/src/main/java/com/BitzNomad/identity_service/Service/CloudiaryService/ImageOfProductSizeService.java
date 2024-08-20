package com.BitzNomad.identity_service.Service.CloudiaryService;

import com.BitzNomad.identity_service.DtoReponese.ImageDTOReponese;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

public interface ImageOfProductSizeService {
    Set<ImageDTOReponese> saveImageOfProductSize(MultipartFile[] imageOfProductSize, Long ProductSizeID, String typeofImage) throws Exception;

}
