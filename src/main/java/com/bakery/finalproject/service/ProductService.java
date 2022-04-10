package com.bakery.finalproject.service;

import com.bakery.finalproject.entity.Product;
import com.bakery.finalproject.exception.NotFoundException;
import com.bakery.finalproject.mapper.ProductMapper;
import com.bakery.finalproject.modelDTO.ProductDTO;
import com.bakery.finalproject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;

    public Product addOrUpdateProduct (ProductDTO productDTO) {
        Product product = productMapper.DTOToEntity(productDTO);
        return productRepository.save(product);
    }

    public void deleteProduct (ProductDTO productDTO) {
        Product product = productMapper.DTOToEntity(productDTO);
        Product foundProduct = productRepository.findById(product.getProductId()).orElseThrow(()-> new NotFoundException("Sorry, the product was not found in the database."));
        productRepository.delete(foundProduct);
    }
}
