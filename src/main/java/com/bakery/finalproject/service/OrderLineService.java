package com.bakery.finalproject.service;

import com.bakery.finalproject.entity.OrderLine;
import com.bakery.finalproject.mapper.OrderLineMapper;
import com.bakery.finalproject.modelDTO.OrderLineDTO;
import com.bakery.finalproject.repository.OrderLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderLineService {
    @Autowired
    private OrderLineRepository orderLineRepository;
    @Autowired
    private OrderLineMapper orderLineMapper;

    public OrderLine addNewOrderLine (OrderLineDTO orderLineDTO) {
        OrderLine orderLine = orderLineMapper.DTOToEntity(orderLineDTO);
        return orderLineRepository.save(orderLine);
    }

    public List<OrderLine> getAllOrderLines() {
        return orderLineRepository.findAll();
    }
}
