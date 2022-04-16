package com.bakery.finalproject.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="order_line")
public class OrderLine {
    @Id
    @GeneratedValue
    private Integer orderLineId;
    @ManyToOne
    private Product product;
    private Integer quantity;
    private Double totalPrice;
    @ManyToOne
    @JoinColumn (name="order_id")
    private Order order;
}
