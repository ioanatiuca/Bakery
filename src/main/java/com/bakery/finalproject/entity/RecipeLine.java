package com.bakery.finalproject.entity;

import com.bakery.finalproject.enums.Ingredients;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RecipeLine {
    private UUID id;
    private Ingredients ingredientName;
    private Integer quantity;
}
