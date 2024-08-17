package com.BitzNomad.identity_service.Service.CloudiaryService;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface CloudiaryValidationService {
    boolean isValid(Map uploadMap);

    boolean isValid(MultipartFile file, String uuid);

    boolean isValid(String public_id);
}
