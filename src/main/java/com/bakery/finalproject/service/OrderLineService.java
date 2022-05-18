package com.bakery.finalproject.service;

import com.bakery.finalproject.entity.OrderLine;
import com.bakery.finalproject.entity.Product;
import com.bakery.finalproject.exception.NotFoundException;
import com.bakery.finalproject.mapper.OrderLineMapper;
import com.bakery.finalproject.modelDTO.OrderLineDTO;
import com.bakery.finalproject.modelDTO.ProductDTO;
import com.bakery.finalproject.repository.OrderLineRepository;
import com.bakery.finalproject.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderLineService {
    private final OrderLineRepository orderLineRepository;
    private final OrderLineMapper orderLineMapper;
    private final ProductRepository productRepository;
    private final ProductService productService;

    public OrderLine addNewOrderLine (OrderLineDTO orderLineDTO) {
        OrderLine orderLine = orderLineMapper.DTOToEntity(orderLineDTO);
        return orderLineRepository.save(orderLine);
    }

    public List<OrderLine> getAllOrderLines() {
        return orderLineRepository.findAll();
    }

    public OrderLine updateOrderLine (OrderLineDTO orderLineDTO) {
        OrderLine orderLine = orderLineMapper.DTOToEntity(orderLineDTO);
        OrderLine foundOrderLine = orderLineRepository.findById(orderLine.getOrderLineId()).orElseThrow(() -> new NotFoundException("Product not found."));
        foundOrderLine.setQuantity(orderLine.getQuantity());
        return orderLineRepository.save(foundOrderLine);
    }

    public void deleteOrderLine (OrderLineDTO orderLineDTO) {
        OrderLine orderLine = orderLineMapper.DTOToEntity(orderLineDTO);
        OrderLine foundOrderLine = orderLineRepository.findById(orderLine.getOrderLineId()).orElseThrow(() -> new NotFoundException("Product not found."));
        orderLineRepository.delete(foundOrderLine);
    }


}
