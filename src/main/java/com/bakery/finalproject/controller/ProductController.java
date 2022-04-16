package com.bakery.finalproject.controller;

import com.bakery.finalproject.entity.Product;
import com.bakery.finalproject.entity.ProductCategory;
import com.bakery.finalproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/{name}")
    @ResponseBody
    public ResponseEntity<Product> getProductByName (@PathVariable("name") String name) {
        Product product = productService.getProductByName(name);
        return ResponseEntity.ok(product);
    }
}
