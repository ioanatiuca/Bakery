package com.bakery.finalproject.repository;

import com.bakery.finalproject.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
}
