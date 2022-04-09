package com.bakery.finalproject.repository;

import com.bakery.finalproject.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    @Query("Select p from Product p where p.name = :name")
    public Optional<Product> findByName(@Param("name") String name);
}
