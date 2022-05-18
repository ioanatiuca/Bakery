package com.bakery.finalproject.modelDTO;

import com.bakery.finalproject.entity.Product;
import com.bakery.finalproject.enums.OrderStatus;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Integer orderId;
    private Integer orderNumber;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private List<Product> shoppingCartDTO;
    private String orderStatus;
    private Double totalPrice;
}
