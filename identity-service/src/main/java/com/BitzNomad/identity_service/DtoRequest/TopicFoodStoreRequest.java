package com.BitzNomad.identity_service.DtoRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TopicFoodStoreRequest {
    Long Id;
    Long FoodStoreId;
    Long TopicId;
}
