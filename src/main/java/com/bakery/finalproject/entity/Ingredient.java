package com.bakery.finalproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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
    @Column(name="ingredient_id")
    private Integer ingredientId;
    private String ingredientName;
    private Double caloriesPer100g;
    private Boolean isAllergen;
    private Boolean pricePerUnit;
    @ManyToMany(mappedBy = "ingredientList")
    private List<Product> productList;

}
