package com.bakery.finalproject.controller;

import com.bakery.finalproject.entity.Product;
import com.bakery.finalproject.entity.ProductCategory;
import com.bakery.finalproject.modelDTO.ProductCategoryDTO;
import com.bakery.finalproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.springframework.http.MediaType.IMAGE_JPEG_VALUE;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/bakery/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts () {
        List<Product> allProducts = productService.getAllProducts();
        return ResponseEntity.ok(allProducts);
    }

    @GetMapping("/category")
    public ResponseEntity<List<ProductCategory>> getAllProductCategories () {
        List<ProductCategory> allProductCategories = productService.getAllProductCategories();
        return ResponseEntity.ok(allProductCategories);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<Product>> getAllProductsInACategory (@PathVariable("id") Integer productCategoryDTOid) {
        List<Product> productList = productService.getAllProductsInACategory(productCategoryDTOid);
        return ResponseEntity.ok(productList);
    }

    @GetMapping(path="/category/image/{fileName}", produces = IMAGE_JPEG_VALUE)
    public byte[] getCategoryImage (@PathVariable("fileName") String fileName) throws IOException {
        return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/Downloads/Poze_SDA/"+fileName));
    }

    @GetMapping(path="/image/{fileName}", produces = IMAGE_JPEG_VALUE)
    public byte[] getProductImage (@PathVariable("fileName") String fileName) throws IOException {
        return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/Downloads/Poze_SDA/"+fileName));
    }

    @GetMapping("/{name}")
    public ResponseEntity<Product> getProductByName (@PathVariable("name") String name) {
        Product product = productService.getProductByName(name);
        return ResponseEntity.ok(product);
    }
}
