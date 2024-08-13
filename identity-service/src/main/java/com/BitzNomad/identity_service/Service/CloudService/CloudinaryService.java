package com.BitzNomad.identity_service.Service.CloudService;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface CloudinaryService {
    Map uploadImage(MultipartFile multipartFile, String uuid) throws Exception;

    boolean deleteImage(String cloudinaryPublicId) throws Exception;
}
