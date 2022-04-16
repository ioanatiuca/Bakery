package com.bakery.finalproject.service;

import com.bakery.finalproject.entity.Order;
import com.bakery.finalproject.enums.OrderStatus;
import com.bakery.finalproject.exception.NotFoundException;
import com.bakery.finalproject.mapper.OrderMapper;
import com.bakery.finalproject.modelDTO.OrderDTO;
import com.bakery.finalproject.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderMapper orderMapper;

    public Order addNewOrder (OrderDTO orderDTO) {
//        addNewOrderLineToOrder(orderLine);
        Order order = orderMapper.DTOToEntity(orderDTO);
        order.setOrderStatus(OrderStatus.APPROVED);
        order.setOrderDate(LocalDate.now());
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders () {
        return orderRepository.findAll();
    }
    public void cancelOrderByNumber (OrderDTO orderDTO) {
        Order order = orderMapper.DTOToEntity(orderDTO);
        Order foundOrder = orderRepository.findByOrderNumber(order.getOrderNumber())
                .orElseThrow(() -> new NotFoundException("Sorry, the order with this number was not found in the database."));
        order.setOrderStatus(OrderStatus.CANCELED);
    }

}
