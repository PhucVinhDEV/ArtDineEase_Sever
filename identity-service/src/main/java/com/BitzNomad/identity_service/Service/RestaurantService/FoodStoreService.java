package com.BitzNomad.identity_service.Service.RestaurantService;


import com.BitzNomad.identity_service.DtoReponese.FoodStoreReponese;
import com.BitzNomad.identity_service.DtoRequest.FoodStoreRegisterRequestDTO;


import com.BitzNomad.identity_service.Entity.Restaurant.FoodStore;
import com.BitzNomad.identity_service.Service.BaseService;


public interface FoodStoreService extends BaseService<FoodStoreReponese, FoodStore, Long> {
  void SendRequestCreatedRestaurant(FoodStoreRegisterRequestDTO foodStoreRegisterRequestDTO) throws Exception;
  void AcceptedRestaurant(FoodStoreRegisterRequestDTO foodStoreRegisterRequestDTO);
}
