package com.bakery.finalproject.controller;

import com.bakery.finalproject.entity.Order;
import com.bakery.finalproject.entity.OrderLine;
import com.bakery.finalproject.modelDTO.OrderDTO;
import com.bakery.finalproject.modelDTO.OrderLineDTO;
import com.bakery.finalproject.service.OrderLineService;
import com.bakery.finalproject.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bakery/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderLineService orderLineService;

    @PostMapping
    public ResponseEntity<Order> addNewOrder (@RequestBody OrderDTO orderDTO){
        Order order = orderService.addNewOrder(orderDTO);
        return ResponseEntity.ok(order);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders () {
        List<Order> allOrders = orderService.getAllOrders();
        return ResponseEntity.ok(allOrders);
    }

    @PostMapping("/cart")
    public ResponseEntity<OrderLine> addNewProduct(@RequestBody OrderLineDTO orderLineDTO) {
        OrderLine orderLine = orderLineService.addNewOrderLine(orderLineDTO);
        return ResponseEntity.ok(orderLine);
    }

    @GetMapping("/cart")
    public ResponseEntity<List<OrderLine>> getAllOrderLines () {
        List<OrderLine> allOrderLines = orderLineService.getAllOrderLines();
        return ResponseEntity.ok(allOrderLines);
    }


}
