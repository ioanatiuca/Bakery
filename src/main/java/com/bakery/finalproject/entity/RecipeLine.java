package com.bakery.finalproject.entity;

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
public class RecipeLine {
    @Id
    @GeneratedValue
    private UUID id;
    private String ingredientName;
    private Integer quantity;
    @ManyToMany
    private List<Recipe> recipes;
}
