package com.BitzNomad.identity_service.Service.RestaurantService.RestauranImpl;

import com.BitzNomad.identity_service.DtoReponese.SizeReponeseDTO;
import com.BitzNomad.identity_service.DtoRequest.SizeRequestDTO;
import com.BitzNomad.identity_service.Entity.Restaurant.Size;
import com.BitzNomad.identity_service.Mapper.Restaurant.SizeMapper;
import com.BitzNomad.identity_service.Respository.RestaurantRepository.SizeRepository;
import com.BitzNomad.identity_service.Service.RestaurantService.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class SizeServiceImpl implements SizeService {

    @Autowired
    SizeMapper sizeMapper;

    @Autowired
    SizeRepository sizeRepository;

    @Override
    public SizeReponeseDTO findById(Long id) {
        return sizeMapper.convertSizeToSizeReponeseDTO(
                sizeRepository.findById(id).orElseThrow(() -> new RuntimeException("Size Not Found") )
        );
    }

    @Override
    public SizeReponeseDTO save(SizeRequestDTO entity) {
        return sizeMapper.convertSizeToSizeReponeseDTO(sizeRepository.save(
                sizeMapper.convertRequestToSize(entity)));
    }

    @Override
    public SizeReponeseDTO update(SizeRequestDTO entity) {
        if(!sizeRepository.existsById(entity.getId()))
            throw new RuntimeException("Size Not Found");
       return  sizeMapper.convertSizeToSizeReponeseDTO(sizeRepository.save(sizeMapper.convertRequestToSize(entity)));
    }

    @Override
    public void deleteById(Long id) {
       Size size = sizeRepository.findById(id).orElseThrow(() -> new RuntimeException("Size Not Found"));
        size.setDeleted(true);
        sizeRepository.save(size);
    }

    @Override
    public Iterator<SizeReponeseDTO> findAll() {
        return null;
    }
}
