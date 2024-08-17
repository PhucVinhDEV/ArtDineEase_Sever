package com.BitzNomad.identity_service.Mapper.Restaurant;

import com.BitzNomad.identity_service.DtoReponese.SizeReponeseDTO;
import com.BitzNomad.identity_service.DtoRequest.SizeRequestDTO;
import com.BitzNomad.identity_service.Entity.Restaurant.Size;
import jakarta.validation.constraints.Max;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class SizeMapper {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ProductSizeMapper productSizeMapper;

    public Size convertRequestToSize(SizeRequestDTO sizeRequestDTO){
        return  modelMapper.map(sizeRequestDTO, Size.class);
    }

    public SizeReponeseDTO convertSizeToSizeReponeseDTO(Size size){
            SizeReponeseDTO sizeReponeseDTO = modelMapper.map(size, SizeReponeseDTO.class);
            if (size.getProductSizes() == null || size.getProductSizes().isEmpty()){
                sizeReponeseDTO.setProductSizeReponeseDTOSet(Set.of());
            }else{
                sizeReponeseDTO.setProductSizeReponeseDTOSet(
                        size.getProductSizes().stream().map(productSizeMapper::convertProductSizeToProductSizeReponeseDTO)
                                .collect(Collectors.toSet())
                );
            }
        return sizeReponeseDTO;
    }

}
