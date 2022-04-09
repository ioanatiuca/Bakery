package com.bakery.finalproject.entity;

import com.bakery.finalproject.enums.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue
    private UUID id;
    private ProductCategory category;
    private String name;
    @ManyToMany
    private List<Ingredient> ingredientList;
    @OneToOne
    private Recipe recipe;
}
