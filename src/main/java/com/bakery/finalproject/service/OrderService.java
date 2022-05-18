package com.bakery.finalproject.service;

import com.bakery.finalproject.entity.Order;
import com.bakery.finalproject.entity.OrderLine;
import com.bakery.finalproject.entity.Product;
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

    public Order addNewOrder (OrderDTO orderDTO) {
        Order order = orderMapper.DTOToEntity(orderDTO);
        order.setOrderDate(LocalDate.now());
//        Double totalPrice=0.0;
//        for (Product p: order.getShoppingCart()){
//            totalPrice=totalPrice+p.getPrice();
//        }
//        order.setTotalPrice(totalPrice);
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
