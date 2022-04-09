package com.bakery.finalproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {
    @Id
    @GeneratedValue
    private UUID id;
    private String ingredientName;
    private Double caloriesPer100g;
    private Boolean isAllergen;
    private Boolean pricePerUnit;
    @ManyToMany
    private List<Product> productList;

}
