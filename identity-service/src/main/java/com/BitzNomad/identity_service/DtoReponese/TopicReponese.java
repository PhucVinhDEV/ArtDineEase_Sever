package com.BitzNomad.identity_service.DtoReponese;

import lombok.Data;

import java.util.Set;

@Data
public class TopicReponese {
    Long id;
    String name;
    Set<FoodStoreReponese> topicFoodStores;
}
