package com.bakery.finalproject.service;

import com.bakery.finalproject.entity.Order;
import com.bakery.finalproject.enums.OrderStatus;
import com.bakery.finalproject.exception.NotFoundException;
import com.bakery.finalproject.mapper.OrderMapper;
import com.bakery.finalproject.modelDTO.OrderDTO;
import com.bakery.finalproject.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderMapper orderMapper;

    public Order addNewOrder (OrderDTO orderDTO) {
        Order order = orderMapper.DTOToEntity(orderDTO);
        Integer orderNumber = generateOrderNumber();
        order.setOrderNumber(orderNumber);
        order.setOrderDate(LocalDate.now());
        return orderRepository.save(order);
    }

    private Integer generateOrderNumber() {
        Random number = new Random();
        Integer orderNumber = number.nextInt(100000,999999);
        return orderNumber;
    }

    public void cancelOrderByNumber (OrderDTO orderDTO) {
        Order order = orderRepository.findByOrderNumber(orderDTO.getOrderNumber())
                .orElseThrow(() -> new NotFoundException("Sorry, the order with this number was not found in the database."));
        order.setOrderStatus(OrderStatus.CANCELED);
    }
}
