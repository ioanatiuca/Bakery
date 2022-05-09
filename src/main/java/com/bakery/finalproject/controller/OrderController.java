package com.bakery.finalproject.controller;

import com.bakery.finalproject.entity.Order;
import com.bakery.finalproject.entity.OrderLine;
import com.bakery.finalproject.modelDTO.OrderDTO;
import com.bakery.finalproject.modelDTO.OrderLineDTO;
import com.bakery.finalproject.service.OrderLineService;
import com.bakery.finalproject.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bakery/order")
@AllArgsConstructor
public class OrderController {

    private OrderService orderService;
    private OrderLineService orderLineService;

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

    @PostMapping("/cart/add")
    public ResponseEntity<OrderLine> addNewOrderLine(@RequestBody OrderLineDTO orderLineDTO) {
        OrderLine orderLine = orderLineService.addNewOrderLine(orderLineDTO);
        return new ResponseEntity(orderLine, HttpStatus.CREATED);
    }

    @GetMapping("/cart/all")
    public ResponseEntity<List<OrderLine>> getAllOrderLines () {
        List<OrderLine> allOrderLines = orderLineService.getAllOrderLines();
        return ResponseEntity.ok(allOrderLines);
    }

    @PostMapping("/cart/update")
    public ResponseEntity<OrderLine> updateOrderLineQuantity (@RequestBody OrderLineDTO orderLineDTO) {
        OrderLine orderLine = orderLineService.updateOrderLine(orderLineDTO);
        return ResponseEntity.ok(orderLine);
    }

    @DeleteMapping("/cart/delete")
    public void deleteOrderLine (OrderLineDTO orderLineDTO) {
        orderLineService.deleteOrderLine(orderLineDTO);
    }
    @GetMapping("/cart/price")
    public ResponseEntity<Double> getOrderLineTotalPrice (OrderLineDTO orderLineDTO) {
        Double orderLineTotalPrice = orderLineService.getOrderLineTotalPrice(orderLineDTO);
        return ResponseEntity.ok(orderLineTotalPrice);
    }

}
