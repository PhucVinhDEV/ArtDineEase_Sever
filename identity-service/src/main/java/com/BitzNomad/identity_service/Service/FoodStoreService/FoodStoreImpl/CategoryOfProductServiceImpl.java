package com.BitzNomad.identity_service.Service.FoodStoreService.FoodStoreImpl;

import com.BitzNomad.identity_service.DtoReponese.CategoryOfProdcutReponeseDTO;
import com.BitzNomad.identity_service.DtoRequest.CategoryOfProductRequestDTO;
import com.BitzNomad.identity_service.Entity.Restaurant.CatagoryOfProduct;
import com.BitzNomad.identity_service.Mapper.Restaurant.CategoryOfProductMapper;
import com.BitzNomad.identity_service.Respository.RestaurantRepository.CategoryOfProductRepository;
import com.BitzNomad.identity_service.Service.FoodStoreService.CategoryOfProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
@Lazy
public class CategoryOfProductServiceImpl implements CategoryOfProductService {

    @Autowired
    CategoryOfProductRepository categoryOfProductRepository;

    @Autowired
    CategoryOfProductMapper categoryOfProductMapper;

    @Override
    public CategoryOfProdcutReponeseDTO findById(Long id) {
        return categoryOfProductMapper.convertEntityToReponese(
                categoryOfProductRepository.findById(id).orElseThrow(
                        () -> new RuntimeException("The category of product id " + id + " does not exist!")
                )
        );
    }

    @Override
    public CategoryOfProdcutReponeseDTO save(CategoryOfProductRequestDTO entity) {
        return categoryOfProductMapper.convertEntityToReponese(
                categoryOfProductRepository.save(
                        categoryOfProductMapper.convertRequsetToEntity(entity)
                )
        );
    }

    @Override
    public CategoryOfProdcutReponeseDTO update(CategoryOfProductRequestDTO entity) {
        if (categoryOfProductRepository.existsById(entity.getId())) {
            return categoryOfProductMapper.convertEntityToReponese(
                    categoryOfProductRepository.save(
                            categoryOfProductMapper.convertRequsetToEntity(entity)
                    )
            );
        }else
            throw new RuntimeException("The category of product id " + entity.getId() + " does not exist!");
    }

    @Override
    public void deleteById(Long id) {
        CatagoryOfProduct catagoryOfProduct = categoryOfProductRepository.findById(id).orElseThrow(
                () -> new RuntimeException("The category of product id " + id + " does not exist!")
        );
        catagoryOfProduct.setDeleted(true);
        categoryOfProductRepository.save(catagoryOfProduct);
    }

    @Override
    public Iterator<CategoryOfProdcutReponeseDTO> findAll() {
        return categoryOfProductRepository.findAll().stream().map(
                categoryOfProductMapper::convertEntityToReponese
        ).iterator();
    }
}
