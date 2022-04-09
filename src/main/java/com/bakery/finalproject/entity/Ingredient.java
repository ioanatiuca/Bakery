package com.bakery.finalproject.entity;

import com.bakery.finalproject.enums.Ingredients;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;
import java.util.UUID;

@Entity
@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {
    @Id
    @GeneratedValue
    private UUID id;
    private Ingredients ingredientName;
    private Double caloriesPer100g;
    private Boolean isAlergen;
    private Boolean pricePerUnit;
    @ManyToMany
    private List<Product> productList;

}
