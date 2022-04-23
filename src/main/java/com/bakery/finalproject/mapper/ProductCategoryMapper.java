package com.bakery.finalproject.mapper;

import com.bakery.finalproject.entity.Client;
import com.bakery.finalproject.entity.ProductCategory;
import com.bakery.finalproject.enums.Country;
import com.bakery.finalproject.modelDTO.ClientDTO;
import com.bakery.finalproject.modelDTO.ProductCategoryDTO;
import com.bakery.finalproject.repository.ClientRepository;
import com.bakery.finalproject.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductCategoryMapper implements Mapper<ProductCategory, ProductCategoryDTO> {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public ProductCategoryDTO entityToDTO(ProductCategory entity) {
        return ProductCategoryDTO.builder()
                .categoryId(entity.getId())
                .description(entity.getDescription())
                .name(entity.getName())
                .photoUrl(entity.getPhotoUrl())
                .build();
    }

    @Override
    public ProductCategory DTOToEntity(ProductCategoryDTO dto) {
        ProductCategory productCategory=productCategoryRepository.findByName(dto.getName()).orElse(new ProductCategory());
        productCategory.setId(dto.getCategoryId());
        productCategory.setName(dto.getName());
        productCategory.setDescription(dto.getDescription());
        productCategory.setPhotoUrl(dto.getPhotoUrl());
        return productCategory;
    }


}
