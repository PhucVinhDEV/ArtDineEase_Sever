package com.BitzNomad.identity_service.Service.FoodStoreService.FoodStoreImpl;

import com.BitzNomad.identity_service.DtoReponese.CustomPageResponse;
import com.BitzNomad.identity_service.DtoReponese.SectionReponesesDTO;
import com.BitzNomad.identity_service.DtoRequest.SectionRequestDTO;
import com.BitzNomad.identity_service.Entity.Restaurant.Section;
import com.BitzNomad.identity_service.Mapper.FoodStore.SectionMapper;
import com.BitzNomad.identity_service.Mapper.PageMapper;
import com.BitzNomad.identity_service.Respository.RestaurantRepository.SectionRepository;
import com.BitzNomad.identity_service.Service.FoodStoreService.SectionService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class SertionServiceImpl implements SectionService {


    @Autowired
    SectionRepository sectionRepository;

    @Autowired
    SectionMapper sectionMapper;

    @Autowired
    PageMapper pageMapper;

    @Override
    public SectionReponesesDTO findById(Long id) {
        return sectionMapper.convertEntityToReponese(sectionRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Section not found")
        ));
    }

    @Override
    public SectionReponesesDTO save(SectionRequestDTO entity) {
        return sectionMapper.convertEntityToReponese(sectionRepository.save(sectionMapper.convertRequestToEntity(entity)));
    }

    @Override
    public SectionReponesesDTO update(SectionRequestDTO entity) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        Section s = sectionRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Section not found")
        );
        s.setDeleted(true);
        sectionRepository.save(s);
    }

    @Override
    public Iterator<SectionReponesesDTO> findAll() {
        return null;
    }


    @Override
    public List<SectionReponesesDTO> getSectionReponesesByFoodStored(Pageable pageable,Long FoodStoreId) {
        return sectionRepository.findAllByIsDeletedAndFoodStoreId(false,FoodStoreId)
                .stream().map( t -> sectionMapper.convertEntityToPageReponese(t,pageable)).toList();

    }

    @Override
    public CustomPageResponse<SectionReponesesDTO> getSectionReponesesBySection(Pageable pageable) {
        Page<SectionReponesesDTO> sectionsPage = sectionRepository.findAllByIsDeleted(false,pageable)
                .map(sectionMapper::convertEntityToReponese);
        return pageMapper.toCustomPageResponse(sectionsPage);
    }
}
