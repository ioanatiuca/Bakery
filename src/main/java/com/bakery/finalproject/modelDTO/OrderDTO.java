package com.bakery.finalproject.modelDTO;

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
    private List<OrderLineDTO> shoppingCartDTO;
    private ClientDTO clientDTO;
}
