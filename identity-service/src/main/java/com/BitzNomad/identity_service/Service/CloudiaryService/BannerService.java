package com.BitzNomad.identity_service.Service.CloudiaryService;

import com.BitzNomad.identity_service.DtoReponese.ImageDTOReponese;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

public interface BannerService {
    Set<ImageDTOReponese> saveBanner(MultipartFile[] imageOfBanner, String typeofImage) throws Exception;

    Set<ImageDTOReponese> saveImgCategory(MultipartFile[] imageOfBanner, Long categoryId) throws Exception;
}
