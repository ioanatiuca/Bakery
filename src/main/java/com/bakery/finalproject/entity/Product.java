package com.bakery.finalproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue
    @Column(name="product_id")
    private Integer productId;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private ProductCategory category;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private String name;

    private String photoUrl;

    @ManyToOne
    @JoinColumn (name="order_id")
    private Order order;

    @ManyToMany
    @JoinTable (name = "product_ingredient",
    joinColumns = @JoinColumn(name = "product_id"),
    inverseJoinColumns = @JoinColumn(name="ingredient_id"))
    private List<Ingredient> ingredientList;

    @OneToOne
    private Recipe recipe;
}
