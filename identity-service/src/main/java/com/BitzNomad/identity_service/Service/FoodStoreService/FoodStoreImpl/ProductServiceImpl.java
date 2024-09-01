package com.BitzNomad.identity_service.Service.FoodStoreService.FoodStoreImpl;

import com.BitzNomad.identity_service.DtoReponese.ProductResponeseDTO;
import com.BitzNomad.identity_service.DtoRequest.ProductRegisterRequestDTO;
import com.BitzNomad.identity_service.DtoRequest.ProductRequestDTO;
import com.BitzNomad.identity_service.Entity.Restaurant.Product;
import com.BitzNomad.identity_service.Mapper.FoodStore.ProductMapper;
import com.BitzNomad.identity_service.Respository.RestaurantRepository.ProductRepository;
import com.BitzNomad.identity_service.Service.CloudiaryService.ImageOfProductService;
import com.BitzNomad.identity_service.Service.FoodStoreService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductMapper productMapper;

    @Autowired
    ImageOfProductService imageOfProductService;

    @Override
    public ProductResponeseDTO findById(Long id) {
        return productMapper.convertProductToProductResponeseDTO(
                productRepository.findById(id).orElseThrow(
                        () -> new RuntimeException("Product not found")
                )
        );
    }

    @Override
    public ProductResponeseDTO save(ProductRequestDTO entity) {
        return productMapper.convertProductToProductResponeseDTO(
                productRepository.save(
                        productMapper.convertProductRequestToProduct(entity)));
    }

    @Override
    public ProductResponeseDTO update(ProductRequestDTO entity) {
        if(!productRepository.existsById(entity.getId())) throw new RuntimeException("Product not found");
        return productMapper.convertProductToProductResponeseDTO(
                productRepository.save(
                        productMapper.convertProductRequestToProduct(entity)
                )
        );
    }

    @Override
    public void deleteById(Long id) {
            Product product = productRepository.findById(id).orElseThrow(
                    () -> new RuntimeException("Product not found")
            );
            product.setDeleted(true);
            productRepository.save(product);
    }

    @Override
    public Iterator<ProductResponeseDTO> findAll() {
        return productRepository.findAll().stream()
                .map(productMapper::convertProductToProductResponeseDTO).iterator();
    }

    @Override
    @Transactional
    public void CreatedProduct(ProductRegisterRequestDTO productRegisterRequestDTO) throws Exception {
        Product p = productRepository.save(productMapper.ConvertProductRegisterToProduct(productRegisterRequestDTO));
        imageOfProductService.saveImageOfProduct(productRegisterRequestDTO.getMultipartFiles(), p.getId(),"MainImage");
    }

    @Override
    public List<ProductResponeseDTO> GetAllProductsByFoodstoreID(Long foodstoreId) throws Exception {
        return productRepository.findAllByFoodStoreId(foodstoreId).stream().map(
                productMapper::convertProductToProductResponeseDTO
        ).toList();
    }
}
