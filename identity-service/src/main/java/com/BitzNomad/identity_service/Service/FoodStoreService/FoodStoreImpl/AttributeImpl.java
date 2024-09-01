package com.BitzNomad.identity_service.Service.FoodStoreService.FoodStoreImpl;

import com.BitzNomad.identity_service.DtoReponese.AttributeResponese;
import com.BitzNomad.identity_service.DtoRequest.AttributeRequestDTO;
import com.BitzNomad.identity_service.Entity.Restaurant.Attribute;
import com.BitzNomad.identity_service.Mapper.FoodStore.AttributeMapper;
import com.BitzNomad.identity_service.Respository.RestaurantRepository.AttributeRepository;
import com.BitzNomad.identity_service.Service.FoodStoreService.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttributeImpl implements AttributeService {

    @Autowired
    AttributeRepository attributeRepository;

    @Autowired
    AttributeMapper attributeMapper;

    @Override
    public AttributeResponese findById(Long id) {
        return attributeMapper.convertEntityToResponese(attributeRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Attribute not found")
        ));
    }

    @Override
    public AttributeResponese save(AttributeRequestDTO entity) {
        return attributeMapper.convertEntityToResponese(attributeRepository.save(attributeMapper.convertRequestToEntity(entity)));
    }

    @Override
    public AttributeResponese update(AttributeRequestDTO entity) {
        Attribute existingAttribute = attributeRepository.findById(entity.getId())
                .orElseThrow(() -> new RuntimeException("Attribute not found"));

        // Update the existing attribute with new values
        existingAttribute.setAtrributeName(entity.getAtrributeName());
        existingAttribute.setAttributeValue(entity.getAtrributeName());
        // Add other fields that need to be updated

        return attributeMapper.convertEntityToResponese(attributeRepository.save(existingAttribute));
    }

    @Override
    public void deleteById(Long id) {
        Attribute attribute = attributeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Attribute not found"));

        attribute.setDeleted(true);  // Assuming there's an `isDeleted` field in the Attribute entity
        attributeRepository.save(attribute);
    }

    @Override
    public Iterator<AttributeResponese> findAll() {
        return attributeRepository.findAll().stream().map(attributeMapper::convertEntityToResponese).iterator();
    }

    @Override
    public List<AttributeResponese> getAttributeByfoodstoreId(Long foodstoreId) {
        return attributeRepository.findAllByFoodStoreId(foodstoreId).stream()
                .map(attributeMapper::convertEntityToResponese)
                .collect(Collectors.toList());
    }
}
