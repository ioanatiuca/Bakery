package com.bakery.finalproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue
    @Column(name="recipe_id")
    private Integer recipeId;
    private String name;
    @OneToMany(mappedBy = "recipe")
    private List<RecipeLine> recipeLines;
    @OneToOne
    private Product product;
}
