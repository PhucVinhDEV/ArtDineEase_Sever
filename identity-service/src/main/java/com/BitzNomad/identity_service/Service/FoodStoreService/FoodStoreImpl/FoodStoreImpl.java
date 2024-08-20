package com.BitzNomad.identity_service.Service.FoodStoreService.FoodStoreImpl;

import com.BitzNomad.identity_service.DtoReponese.FoodStoreReponese;
import com.BitzNomad.identity_service.DtoRequest.FoodStoreRegisterRequestDTO;
import com.BitzNomad.identity_service.Entity.Restaurant.FoodStore;
import com.BitzNomad.identity_service.Mapper.Restaurant.FoodStoreMapper;
import com.BitzNomad.identity_service.Respository.RestaurantRepository.FoodStoreRepository;
import com.BitzNomad.identity_service.Service.CloudiaryService.ImageOfFoodStoreService;
import com.BitzNomad.identity_service.Service.FoodStoreService.FoodStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;

@Service
public class FoodStoreImpl implements FoodStoreService {

    @Autowired
    FoodStoreRepository foodStoreRepository;

    @Autowired
    FoodStoreMapper foodStoreMapper;

    @Autowired
    ImageOfFoodStoreService imageOfFoodStoreService;

    @Override
    public FoodStoreReponese findById(Long id) {
        return foodStoreMapper.convertFoodStoreToFoodStoreReponese(
                foodStoreRepository.findById(id).orElseThrow(RuntimeException::new)
        );
    }

    @Override
    public FoodStoreReponese save(FoodStore entity) {
        return foodStoreMapper.convertFoodStoreToFoodStoreReponese(
                foodStoreRepository.save(entity)
        );
    }

    @Override
    public FoodStoreReponese update(FoodStore entity) {
        if(!foodStoreRepository.existsById(entity.getId())) throw new RuntimeException("Restaurant is not exists");
        return foodStoreMapper.convertFoodStoreToFoodStoreReponese(
                foodStoreRepository.save(entity)
        );
    }

    @Override
    public void deleteById(Long id) {
        FoodStore restaurant = foodStoreRepository.findById(id).orElseThrow(()
                -> new RuntimeException("FoodStore not found"));
        restaurant.setDeleted(true);
        foodStoreRepository.save(restaurant);
    }

    @Override
    public Iterator<FoodStoreReponese> findAll() {
        return foodStoreRepository.findAll().stream()
                .map(foodStoreMapper::convertFoodStoreToFoodStoreReponese).iterator();
    }

    @Override
    @Transactional
    public void SendRequestCreatedRestaurant(FoodStoreRegisterRequestDTO restaurantRequestDTO) throws Exception {
            FoodStore foodStore = foodStoreRepository.save(foodStoreMapper.convertFoodStoreRequestToFoodStore(restaurantRequestDTO));

        imageOfFoodStoreService.saveImageOfFoodStore(restaurantRequestDTO.getMultipartFiles()
                    ,foodStore.getId(),"MainImage");
    }

    @Override
    public void AcceptedRestaurant(FoodStoreRegisterRequestDTO foodStoreRegisterRequestDTO) {

    }
}
