package com.BitzNomad.identity_service.Service.FoodStoreService;

import com.BitzNomad.identity_service.DtoReponese.CustomPageResponse;
import com.BitzNomad.identity_service.DtoReponese.SectionReponesesDTO;
import com.BitzNomad.identity_service.DtoRequest.SectionRequestDTO;
import com.BitzNomad.identity_service.Service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SectionService extends BaseService<SectionReponesesDTO, SectionRequestDTO,Long> {
    List<SectionReponesesDTO> getSectionReponesesByFoodStored(Pageable pageable,Long FoodStoreId);
    CustomPageResponse<SectionReponesesDTO> getSectionReponesesBySection(Pageable pageable);
}
