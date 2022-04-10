package com.bakery.finalproject.entity;

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
public class RecipeLine {
    @Id
    @GeneratedValue
    private Integer recipeLineId;
    private String ingredientName;
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name="recipe_id")
    private Recipe recipe;
}
