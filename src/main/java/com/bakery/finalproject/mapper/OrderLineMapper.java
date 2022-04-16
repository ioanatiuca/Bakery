package com.bakery.finalproject.mapper;

import com.bakery.finalproject.entity.OrderLine;
import com.bakery.finalproject.modelDTO.OrderLineDTO;
import org.springframework.stereotype.Component;

@Component
public class OrderLineMapper implements Mapper<OrderLine, OrderLineDTO>{
    @Override
    public OrderLineDTO entityToDTO(OrderLine entity) {
        return OrderLineDTO.builder()
                .orderLineId(entity.getOrderLineId())
                .product(entity.getProduct())
                .quantity(entity.getQuantity())
                .totalPrice(entity.getTotalPrice())
                .build();
    }

    @Override
    public OrderLine DTOToEntity(OrderLineDTO dto) {
        return OrderLine.builder()
                .orderLineId(dto.getOrderLineId())
                .product(dto.getProduct())
                .quantity(dto.getQuantity())
                .totalPrice(dto.getTotalPrice())
                .build();
    }
}
