package com.BitzNomad.identity_service.Service.FoodStoreService.FoodStoreImpl;

import com.BitzNomad.identity_service.DtoRequest.MenuSectionRequest;
import com.BitzNomad.identity_service.Entity.Restaurant.MenuSection;
import com.BitzNomad.identity_service.Mapper.FoodStore.MenuSectionMapper;
import com.BitzNomad.identity_service.Respository.RestaurantRepository.MenuSectionRepository;
import com.BitzNomad.identity_service.Service.FoodStoreService.MenuSectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MenuSectionImpl implements MenuSectionService {

    @Autowired
    MenuSectionRepository menuSectionRepository;

    @Autowired
    MenuSectionMapper menuSectionMapper;

    @Override
    public MenuSection Created(MenuSectionRequest menuSectionRequest) {
        Optional<MenuSection> menuSectionOptional = menuSectionRepository.findByProductSizeIdAndSectionId(menuSectionRequest.getProductSizeId(), menuSectionRequest.getSectionId());
        menuSectionOptional.ifPresent(menuSection -> menuSection.setDeleted(true));
           return menuSectionRepository.save(menuSectionMapper.convertRequestToEntity(menuSectionRequest));
    }

    @Override
    public MenuSection Updated(MenuSectionRequest menuSectionRequest) {
        MenuSection menuSection = menuSectionRepository.findById(menuSectionRequest.getId())
                .orElseThrow(() -> new RuntimeException("Menu Section Not Found"));
        return menuSectionRepository.save(menuSectionMapper.convertRequestToEntity(menuSectionRequest));
    }

    @Override
    public void ChangeStatus(Long menuSectionId) {
            MenuSection menuSection = menuSectionRepository.findById(menuSectionId).orElseThrow(
                    () -> new RuntimeException("Menu Section Not Found")
            );
        if (menuSection.isDeleted() == true) {
            menuSection.setDeleted(false);
        } else {
            menuSection.setDeleted(true);
        }
        menuSectionRepository.save(menuSection);
    }
}
