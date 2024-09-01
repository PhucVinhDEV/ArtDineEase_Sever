package com.BitzNomad.identity_service.Service.FoodStoreService.FoodStoreImpl;

import com.BitzNomad.identity_service.DtoReponese.CategoryOfFoodStoreReponeseDTO;
import com.BitzNomad.identity_service.DtoRequest.CategoryOfFoodStoreRequestDTO;
import com.BitzNomad.identity_service.Entity.Restaurant.CategoryOfFoodStore;
import com.BitzNomad.identity_service.Mapper.FoodStore.CategoryOfFoodStoreMapper;
import com.BitzNomad.identity_service.Respository.RestaurantRepository.CategoryOfFoodStoreRepository;
import com.BitzNomad.identity_service.Service.FoodStoreService.CategoryOfFoodStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class CategoryOfFoodStoreImpl implements CategoryOfFoodStoreService {

    @Autowired
    CategoryOfFoodStoreRepository categoryOfFoodStoreRepository;

    @Autowired
    CategoryOfFoodStoreMapper categoryOfFoodStoreMapper;

    @Override
    public CategoryOfFoodStoreReponeseDTO findById(Long id) {
        return categoryOfFoodStoreMapper.convertToReponeseDTO(categoryOfFoodStoreRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Category of Food Store Not Found")
        ));
    }

    @Override
    public CategoryOfFoodStoreReponeseDTO save(CategoryOfFoodStoreRequestDTO entity) {
        return categoryOfFoodStoreMapper.convertToReponeseDTO(categoryOfFoodStoreRepository.save(
                categoryOfFoodStoreMapper.convertRequestToCategoryOfFoodStore(entity)
        ));
    }

    @Override
    public CategoryOfFoodStoreReponeseDTO update(CategoryOfFoodStoreRequestDTO entity) {
        if(categoryOfFoodStoreRepository.existsById(entity.getId())){
            return categoryOfFoodStoreMapper.convertToReponeseDTO(categoryOfFoodStoreRepository.save(
                    categoryOfFoodStoreMapper.convertRequestToCategoryOfFoodStore(entity)
            ));
        }else
            throw new RuntimeException("Category of Food Store Not Found");
    }

    @Override
    public void deleteById(Long id) {
        CategoryOfFoodStore categoryOfFoodStore = categoryOfFoodStoreRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Category of Food Store Not Found")
        );
        categoryOfFoodStore.setDeleted(true);
        categoryOfFoodStoreRepository.save(categoryOfFoodStore);
    }

    @Override
    public Iterator<CategoryOfFoodStoreReponeseDTO> findAll() {
        return categoryOfFoodStoreRepository.findAll().stream().map(categoryOfFoodStoreMapper::convertToReponeseDTO).iterator();
    }
}
