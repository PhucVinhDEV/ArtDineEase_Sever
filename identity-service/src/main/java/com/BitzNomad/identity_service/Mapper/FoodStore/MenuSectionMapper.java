package com.BitzNomad.identity_service.Mapper.FoodStore;

import com.BitzNomad.identity_service.DtoRequest.MenuSectionRequest;
import com.BitzNomad.identity_service.DtoRequest.SectionRequestDTO;
import com.BitzNomad.identity_service.Entity.Restaurant.MenuSection;
import com.BitzNomad.identity_service.Entity.Restaurant.Section;
import com.BitzNomad.identity_service.Respository.RestaurantRepository.ProductSizeRepository;
import com.BitzNomad.identity_service.Respository.RestaurantRepository.SectionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MenuSectionMapper {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    SectionRepository sectionRepository;

    @Autowired
    ProductSizeRepository psRepository;

    public MenuSection convertRequestToEntity(MenuSectionRequest requestDTO){
        MenuSection s = modelMapper.map(requestDTO, MenuSection.class);
        s.setSection(sectionRepository.findById(requestDTO.getSectionId()).orElseThrow(
                () -> new RuntimeException("Section not found")
        ));
        s.setProductSize(psRepository.findById(requestDTO.getProductSizeId()).orElseThrow(
                () -> new RuntimeException("Product size not found")
        ));
        return s;
    }

}
