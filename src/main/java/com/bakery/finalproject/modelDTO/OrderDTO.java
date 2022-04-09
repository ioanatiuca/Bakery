package com.bakery.finalproject.modelDTO;

import com.bakery.finalproject.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class OrderDTO {
    private Integer orderNumber;
    private Integer discount;
    private OrderStatus orderStatus;
    private Date orderDate;
    private Date deliveryDate;
    private List<OrderLineDTO> shoppingCartDTO;
}
