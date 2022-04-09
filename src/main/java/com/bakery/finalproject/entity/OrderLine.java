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
public class OrderLine {
    @Id
    @GeneratedValue
    private UUID id;
    @ManyToOne
    private Product product;
    private Integer quantity;
    private Double totalPrice;
    @ManyToMany
    private List<Order> orders;
}
