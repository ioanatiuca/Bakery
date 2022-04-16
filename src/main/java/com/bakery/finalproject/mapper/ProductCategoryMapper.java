package com.bakery.finalproject.mapper;

import com.bakery.finalproject.entity.Client;
import com.bakery.finalproject.entity.ProductCategory;
import com.bakery.finalproject.enums.Country;
import com.bakery.finalproject.modelDTO.ClientDTO;
import com.bakery.finalproject.modelDTO.ProductCategoryDTO;
import com.bakery.finalproject.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductCategoryMapper implements Mapper<ProductCategory, ProductCategoryDTO> {

    @Override
    public ProductCategoryDTO entityToDTO(ProductCategory entity) {
        return null;
    }

    @Override
    public ProductCategory DTOToEntity(ProductCategoryDTO dto) {
        return null;
    }


}
