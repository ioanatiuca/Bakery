package com.bakery.finalproject.entity;

import com.bakery.finalproject.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue
    private UUID id;
    private Integer orderNumber;
    private Integer discount;
    private OrderStatus orderStatus;
    private Date orderDate;
    private Date deliveryDate;
    //@Autowired
  //  private List<OrderLine> shoppingCart;
    @ManyToOne
    private Client client;

}
