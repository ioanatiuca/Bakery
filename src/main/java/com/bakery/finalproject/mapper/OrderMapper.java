package com.bakery.finalproject.mapper;

import com.bakery.finalproject.entity.Order;
import com.bakery.finalproject.modelDTO.OrderDTO;
import com.bakery.finalproject.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class OrderMapper implements Mapper<Order, OrderDTO> {
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public OrderDTO entityToDTO(Order entity) {
        return OrderDTO.builder()
                .orderId(entity.getOrderId())
                .orderDate(entity.getOrderDate())
                .deliveryDate(entity.getDeliveryDate())
                .build();
    }

    @Override
    public Order DTOToEntity(OrderDTO dto) {
        Order order = orderRepository.findByOrderNumber(dto.getOrderId()).orElse(new Order());
        order.setOrderDate(dto.getOrderDate());
        order.setDeliveryDate(dto.getDeliveryDate());
        order.setOrderNumber(generateOrderNumber());
        order.setDiscount(0);
       // order.setShoppingCart(dto.getShoppingCartDTO());
        return order;
    }

    private Integer generateOrderNumber() {
        Random number = new Random();
        Integer orderNumber = number.nextInt(100000,999999);
        return orderNumber;
    }
}
