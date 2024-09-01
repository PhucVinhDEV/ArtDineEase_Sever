package com.BitzNomad.identity_service.Mapper;

import com.BitzNomad.identity_service.DtoReponese.CustomPageResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class PageMapper {

    @Autowired
    ModelMapper modelMapper;


    /**
     * Converts a Page object directly into a CustomPageResponse object.
     *
     * @param page the Page object
     * @param <T>  the type of the content in the Page
     * @return a CustomPageResponse object
     */
    public <T> CustomPageResponse<T> toCustomPageResponse(Page<T> page) {
        CustomPageResponse<T> customResponse = modelMapper.map(page, CustomPageResponse.class);

        return customResponse;
    }
}
