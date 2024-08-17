package com.BitzNomad.identity_service.DtoReponese;

import com.BitzNomad.identity_service.Entity.Restaurant.Section;

import java.util.List;
import java.util.Set;

public class RestaurantDeatailReponesesDTO {

    Long id;
    String name;
    String address;
    String description;
    String phoneNumber;
    String OwnerName;
    String OwnerPhoneNumber;
    String OwnerEmail;
    Set<String> catagoryOfRestaurant;
    Set<AttributeReponeseDTO> attributes;
    Set<SectionReponeseDTO> sections;
    List<ImageDTOReponese> imageDTOReponeseList;
}
