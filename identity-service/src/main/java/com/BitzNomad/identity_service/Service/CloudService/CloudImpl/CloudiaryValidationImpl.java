package com.BitzNomad.identity_service.Service.CloudService.CloudImpl;

import com.BitzNomad.identity_service.Service.CloudService.CloudiaryValidationService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Service
@Lazy
public class CloudiaryValidationImpl implements CloudiaryValidationService {
    @Override
    public boolean isValid(Map uploadMap) {
        return uploadMap != null && hasPublicId(uploadMap) && hasUrl(uploadMap);
    }

    @Override
    public boolean isValid(MultipartFile file, String uuid) {
        return file != null && uuid != null;
    }

    @Override
    public boolean isValid(String public_id) {
        return public_id != null;

    }
    private boolean hasPublicId(Map uploadMap) {
        return uploadMap.get("public_id") != null;
    }

    private boolean hasUrl(Map uploadMap) {
        return uploadMap.get("url") != null;
    }
}
