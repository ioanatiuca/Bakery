package com.bakery.finalproject.modelDTO;

import com.bakery.finalproject.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class OrderDTO {
    private Integer orderId;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private List<OrderLineDTO> shoppingCartDTO;
}
