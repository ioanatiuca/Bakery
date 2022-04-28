package com.bakery.finalproject.repository;

import com.bakery.finalproject.entity.Product;
import com.bakery.finalproject.entity.ProductCategory;
import com.bakery.finalproject.modelDTO.ProductCategoryDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("Select p from Product p where p.name = :name")
    public Optional<Product> findByName(@Param("name") String name);

    @Query("Select p.category from Product p group by p.category")
    public List<ProductCategory> getAllProductCategories ();

    @Query("Select p from Product p where p.category.name = :categoryName")
    public List<Product> findAllByCategoryName(@Param("categoryName") String productCategoryDTOname);
}
