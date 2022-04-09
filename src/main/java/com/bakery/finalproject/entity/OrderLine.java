package com.bakery.finalproject.entity;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class OrderLine {
    private UUID id;
    private Product product;
    private Integer quantity;
    private Double totalPrice;
}
