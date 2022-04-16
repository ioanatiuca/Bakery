package com.bakery.finalproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategory {
//    BAIGLI,
//    LAYERED_CAKE,
//    CHEESE_CAKE,
//    MUFFINS_AND_CUPCAKES,
//    OTHER

    @Id
    @GeneratedValue()
    @Column(name = "category_id")
    Integer id;

    @Column
    String name;

    @Column
    String description;

    public String getName() {
        return name;
    }
}
