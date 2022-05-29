package com.bakery.finalproject.controller;

import com.bakery.finalproject.entity.Order;
import com.bakery.finalproject.modelDTO.OrderDTO;
import com.bakery.finalproject.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bakery/order")
@AllArgsConstructor
public class OrderController {

    private OrderService orderService;

    @PostMapping("/add")
    public ResponseEntity<Order> addNewOrder (@RequestBody OrderDTO orderDTO){
        Order order = orderService.addNewOrder(orderDTO);
        return new ResponseEntity(order, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Order>> getAllOrders () {
        List<Order> allOrders = orderService.getAllOrders();
        return ResponseEntity.ok(allOrders);
    }

    @PostMapping("/cancel/{number}")
    public ResponseEntity<Order> cancelOrderByNumber (@PathVariable("number") Integer orderDTONumber) {
        Order order = orderService.cancelOrderByNumber(orderDTONumber);
        return ResponseEntity.ok(order);
    }

}
