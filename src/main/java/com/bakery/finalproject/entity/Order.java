package com.bakery.finalproject.entity;

import com.bakery.finalproject.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue
    private UUID id;
    private Integer orderNumber; //random, 6 cifre
    private Integer discount;
    private OrderStatus orderStatus;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    @ManyToMany
    private List<OrderLine> shoppingCart;
    @ManyToOne
    private Client client;

}
