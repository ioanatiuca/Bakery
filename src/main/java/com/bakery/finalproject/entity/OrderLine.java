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

    private Integer quantity;
    private Double totalPrice;


}
