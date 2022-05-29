package com.bakery.finalproject.service;

import com.bakery.finalproject.entity.Order;
import com.bakery.finalproject.enums.OrderStatus;
import com.bakery.finalproject.exception.NotFoundException;
import com.bakery.finalproject.mapper.OrderMapper;
import com.bakery.finalproject.modelDTO.OrderDTO;
import com.bakery.finalproject.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public Order addNewOrder (OrderDTO orderDTO) {
        Order order = orderMapper.DTOToEntity(orderDTO);
        order.setOrderDate(LocalDate.now());
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders () {
        return orderRepository.findAll();
    }

    public Order cancelOrderByNumber (Integer orderDTONumber) {
        Order foundOrder = orderRepository.findByOrderNumber(orderDTONumber)
                .orElseThrow(() -> new NotFoundException("An order with this number was not found."));
        foundOrder.setOrderStatus(OrderStatus.CANCELED);
        return orderRepository.save(foundOrder);
    }

}
