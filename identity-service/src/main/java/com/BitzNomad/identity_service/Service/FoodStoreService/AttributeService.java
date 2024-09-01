package com.BitzNomad.identity_service.Service.FoodStoreService;

import com.BitzNomad.identity_service.DtoReponese.AttributeResponese;
import com.BitzNomad.identity_service.DtoRequest.AttributeRequestDTO;
import com.BitzNomad.identity_service.Entity.Restaurant.Attribute;
import com.BitzNomad.identity_service.Service.BaseService;

import java.util.List;

public interface AttributeService extends BaseService<AttributeResponese, AttributeRequestDTO,Long> {
    List<AttributeResponese> getAttributeByfoodstoreId(Long foodstoreId);
}
