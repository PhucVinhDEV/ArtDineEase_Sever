package com.BitzNomad.identity_service.Service.CloudService.CloudImpl;

import com.BitzNomad.identity_service.Exception.AppException;
import com.BitzNomad.identity_service.Exception.ErrorCode;
import com.BitzNomad.identity_service.Service.CloudService.CloudiaryValidationService;
import com.BitzNomad.identity_service.Service.CloudService.CloudinaryService;
import com.cloudinary.Api;
import com.cloudinary.Cloudinary;
import com.cloudinary.api.ApiResponse;
import org.cloudinary.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
@Lazy
public class CloudiaryImpl implements CloudinaryService {

    @Autowired
    Cloudinary cloudinary;

    @Autowired
    CloudiaryValidationService cloudiaryValidationService;

    @Override
    public Map uploadImage(MultipartFile multipartFile, String uuid) throws Exception {
       if(multipartFile.isEmpty()) throw  new AppException(ErrorCode.FILE_EMPTY);
       if (!cloudiaryValidationService.isValid(multipartFile, uuid)) throw new AppException(ErrorCode.IMAGE_ERROR);

       Map param = new HashMap<String,Object>(){
           {
               // Đặt UUID cho file trên Cloudinary, giúp quản lý file với định danh duy nhất.
               put("public_id", uuid);
               // Ghi đè nếu đã có uuid
               put("overwrite", true);
               // Đặt là auto, Cloudinary sẽ tự động nhận diện loại tài nguyên (ảnh, video, v.v.).
               put("resource_type", "auto");
           }
       };
        File fileToUpload = File.createTempFile("temp-file", multipartFile.getOriginalFilename());
        multipartFile.transferTo(fileToUpload);
        Map upload = this.cloudinary.uploader().upload(fileToUpload, param);
        return upload;
    }

    @Override
    public boolean deleteImage(String cloudinaryPublicId) throws Exception {
        if(!cloudiaryValidationService.isValid(cloudinaryPublicId)) throw new AppException(ErrorCode.IMAGE_ERROR);
      ApiResponse apiResponse = this.cloudinary.api()
                .deleteResources(Collections.singletonList(cloudinaryPublicId), new HashMap());

        JSONObject deleted = (JSONObject) apiResponse.get("deleted");
        String deletingResult = deleted.get(cloudinaryPublicId).toString();


        return deletingResult.equals("deleted");
    }
}
