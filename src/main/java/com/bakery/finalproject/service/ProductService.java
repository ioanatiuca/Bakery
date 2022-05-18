package com.bakery.finalproject.service;

import com.bakery.finalproject.entity.Product;
import com.bakery.finalproject.entity.ProductCategory;
import com.bakery.finalproject.exception.NotFoundException;
import com.bakery.finalproject.mapper.ProductMapper;
import com.bakery.finalproject.modelDTO.ProductCategoryDTO;
import com.bakery.finalproject.modelDTO.ProductDTO;
import com.bakery.finalproject.repository.ProductCategoryRepository;
import com.bakery.finalproject.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;
    private ProductMapper productMapper;
    private ProductCategoryRepository categoryRepository;

    public Product addOrUpdateProduct (ProductDTO productDTO) {
        Product product = productMapper.DTOToEntity(productDTO);
        product.setPhotoUrl(setProductPhotoUrl(product.getProductId()));
        product.getCategory().setPhotoUrl(setCategoryPhotoUrl(product.getCategory().getId()));
        return productRepository.save(product);
    }

    private String setCategoryPhotoUrl(Integer categoryId) {
        String[] imageNames =  {"cakes.jpg", "pastry.jpg", "muffins.jpg", "cookies.jpg"};
        return ServletUriComponentsBuilder.fromCurrentContextPath().path("api/bakery/product/category/image/"+imageNames[categoryId-1]).toUriString();
    }

    private String setProductPhotoUrl(Integer productId) {
        String[] imageNames =  {"1.jpg", "2.jpg", "3.jpg", "4.jpg","5.jpg", "6.jpg", "7.jpg", "8.jpg","9.jpg", "10.jpg", "11.jpg", "12.jpg"};
        return ServletUriComponentsBuilder.fromCurrentContextPath().path("api/bakery/product/image/"+imageNames[productId-1]).toUriString();
    }

    public void deleteProduct (ProductDTO productDTO) {
        Product product = productMapper.DTOToEntity(productDTO);
        Product foundProduct = productRepository.findById(product.getProductId()).orElseThrow(()-> new NotFoundException("Sorry, the product was not found in the database."));
        productRepository.delete(foundProduct);
    }

    public List<Product> getAllProducts () {
        return productRepository.findAll();
    }

    public List<Product> getAllProductsInACategory (Integer productCategoryDTOid) {
        List<Product> productList = productRepository.findAllByCategoryId(productCategoryDTOid);
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
