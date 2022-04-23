package com.bakery.finalproject.service;

import com.bakery.finalproject.entity.Product;
import com.bakery.finalproject.entity.ProductCategory;
import com.bakery.finalproject.exception.NotFoundException;
import com.bakery.finalproject.mapper.ProductMapper;
import com.bakery.finalproject.modelDTO.ProductCategoryDTO;
import com.bakery.finalproject.modelDTO.ProductDTO;
import com.bakery.finalproject.repository.ProductCategoryRepository;
import com.bakery.finalproject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductCategoryRepository categoryRepository;

    public Product addOrUpdateProduct (ProductDTO productDTO) {
        Product product = productMapper.DTOToEntity(productDTO);
        return productRepository.save(product);
    }

    public void deleteProduct (ProductDTO productDTO) {
        Product product = productMapper.DTOToEntity(productDTO);
        Product foundProduct = productRepository.findById(product.getProductId()).orElseThrow(()-> new NotFoundException("Sorry, the product was not found in the database."));
        productRepository.delete(foundProduct);
    }

    public List<Product> getAllProducts () {
        return productRepository.findAll();
    }

    public List<Product> getAllProductsInACategory (ProductCategoryDTO productCategoryDTO) {
        List<Product> productList = productRepository.findAllByCategoryName(productCategoryDTO);
        return productList;
    }

    public List<ProductCategory> getAllProductCategories () {
//        return productRepository.getAllProductCategories();
        return categoryRepository.findAll();
    }

    public Product getProductByName (String name) {
        return productRepository.findByName(name).orElseThrow(() -> new NotFoundException("Sorry, product not found."));
    }
}
