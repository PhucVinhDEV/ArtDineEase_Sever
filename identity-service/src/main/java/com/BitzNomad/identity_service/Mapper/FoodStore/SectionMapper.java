package com.BitzNomad.identity_service.Mapper.FoodStore;

import com.BitzNomad.identity_service.DtoReponese.SectionReponesesDTO;
import com.BitzNomad.identity_service.DtoRequest.SectionRequestDTO;
import com.BitzNomad.identity_service.Entity.Restaurant.MenuSection;
import com.BitzNomad.identity_service.Entity.Restaurant.Section;
import com.BitzNomad.identity_service.Mapper.PageMapper;
import com.BitzNomad.identity_service.Respository.RestaurantRepository.FoodStoreRepository;
import com.BitzNomad.identity_service.Respository.RestaurantRepository.MenuSectionRepository;
import com.BitzNomad.identity_service.Respository.RestaurantRepository.SectionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SectionMapper {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    FoodStoreRepository foodStoreRepository;

    @Autowired
    ProductSizeMapper productSizeMapper;

    @Autowired
    MenuSectionRepository menuSectionRepository;

    @Autowired
    PageMapper pageMapper;
    @Autowired
    private SectionRepository sectionRepository;

    public Section convertRequestToEntity(SectionRequestDTO requestDTO) {
        Section section = modelMapper.map(requestDTO, Section.class);
        section.setFoodStore(foodStoreRepository.findById(requestDTO.getFoodstoreID())
                .orElseThrow(() -> new RuntimeException("FoodStore not found with id: " + requestDTO.getFoodstoreID()))
        );
        return section;
    }

    public SectionReponesesDTO convertEntityToPageReponese(Section section, Pageable pageable) {
        SectionReponesesDTO sectionReponesesDTO = modelMapper.map(section, SectionReponesesDTO.class);
        sectionReponesesDTO.setFoodstoreName(section.getFoodStore().getName());
//        if (section.getMenuSections()== null || section.getMenuSections().isEmpty()) {
//            sectionReponesesDTO.setProductResponeseDTOSet(Set.of());
//        }else {
//            sectionReponesesDTO.setProductResponeseDTOSet(section.getMenuSections()
//                    .stream().map(MenuSection::getProductSize).collect(Collectors.toSet())
//                    .stream().map(productSizeMapper::convertProductSizeToProductSizeReponeseDTO).collect(Collectors.toSet()));
//        }
        sectionReponesesDTO.setProductResponeseDTOSet(
                pageMapper.toCustomPageResponse(menuSectionRepository.findBySectionAndIsDeleted(section,false,pageable).map(MenuSection::getProductSize).map(productSizeMapper::convertProductSizeToProductSizeReponeseDTO))
        );
        return sectionReponesesDTO;
    }

    public SectionReponesesDTO convertEntityToReponese(Section section) {
        SectionReponesesDTO sectionReponesesDTO = modelMapper.map(section, SectionReponesesDTO.class);
        sectionReponesesDTO.setFoodstoreName(section.getFoodStore().getName());
        return sectionReponesesDTO;
    }
}
