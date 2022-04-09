package com.bakery.finalproject.repository;

import com.bakery.finalproject.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RecipeRepository extends JpaRepository<Recipe, UUID> {
}
