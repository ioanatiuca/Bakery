package com.bakery.finalproject.mapper;

import com.bakery.finalproject.entity.Order;
import com.bakery.finalproject.modelDTO.OrderDTO;
import com.bakery.finalproject.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper implements Mapper<Order, OrderDTO> {
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public OrderDTO entityToDTO(Order entity) {
        return OrderDTO.builder()
                .discount(entity.getDiscount())
                .deliveryDate(entity.getDeliveryDate())
                .build();
    }

    @Override
    public Order DTOToEntity(OrderDTO dto) {
        Order order = orderRepository.findByOrderNumber(dto.getOrderNumber()).orElse(new Order());
        order.setOrderDate(dto.getOrderDate());
        order.setDeliveryDate(dto.getDeliveryDate());
        order.setOrderStatus(dto.getOrderStatus());
        order.setOrderNumber(dto.getOrderNumber());
        order.setDiscount(dto.getDiscount());
       // order.setShoppingCart(dto.getShoppingCartDTO());
        return order;
    }
}
