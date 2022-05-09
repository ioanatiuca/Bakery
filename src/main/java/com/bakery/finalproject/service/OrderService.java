package com.bakery.finalproject.service;

import com.bakery.finalproject.entity.Order;
import com.bakery.finalproject.entity.OrderLine;
import com.bakery.finalproject.enums.OrderStatus;
import com.bakery.finalproject.exception.NotFoundException;
import com.bakery.finalproject.mapper.OrderMapper;
import com.bakery.finalproject.modelDTO.OrderDTO;
import com.bakery.finalproject.repository.OrderLineRepository;
import com.bakery.finalproject.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final OrderLineRepository orderLineRepository;

    public Order addNewOrder (OrderDTO orderDTO) {
        Order order = orderMapper.DTOToEntity(orderDTO);
        order.setOrderStatus(OrderStatus.APPROVED);
        order.setOrderDate(LocalDate.now());
        Double orderTotalPrice = getOrderTotalPrice(order);
        order.setTotalPrice(orderTotalPrice);
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

    public Double getOrderTotalPrice (Order order) {
        List<OrderLine> allOrderLines = orderLineRepository.findAllByOrderId(order.getOrderId());
        Double totalPrice=0.0;
        for (OrderLine orderLine: allOrderLines) {
            totalPrice=totalPrice+orderLine.getTotalPrice();
        }
        return totalPrice;
    }

}
