package com.bakery.finalproject.mapper;

import com.bakery.finalproject.entity.Product;
import com.bakery.finalproject.modelDTO.ProductDTO;
import com.bakery.finalproject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper implements Mapper<Product, ProductDTO> {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductDTO entityToDTO(Product entity) {
        return ProductDTO.builder()
                .productId(entity.getProductId())
                .category(entity.getCategory())
                .name(entity.getName())
                .build();
    }

    @Override
    public Product DTOToEntity(ProductDTO dto) {
        Product product = productRepository.findByName(dto.getName()).orElse(new Product());
        product.setProductId(dto.getProductId());
        product.setCategory(dto.getCategory());
        product.setName(dto.getName());
        return product;
    }
}
