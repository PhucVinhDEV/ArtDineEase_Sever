package com.BitzNomad.identity_service.Service.FoodStoreService;

import com.BitzNomad.identity_service.DtoRequest.MenuSectionRequest;
import com.BitzNomad.identity_service.Entity.Restaurant.MenuSection;

public interface MenuSectionService {
    MenuSection Created (MenuSectionRequest menuSectionRequest);
    MenuSection Updated (MenuSectionRequest menuSectionRequest);
    void ChangeStatus (Long menuSectionId);
}
