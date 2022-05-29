package com.bakery.finalproject.mapper;

import com.bakery.finalproject.entity.Client;
import com.bakery.finalproject.entity.Order;
import com.bakery.finalproject.enums.OrderStatus;
import com.bakery.finalproject.exception.NotFoundException;
import com.bakery.finalproject.modelDTO.OrderDTO;
import com.bakery.finalproject.repository.ClientRepository;
import com.bakery.finalproject.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@AllArgsConstructor
public class OrderMapper implements Mapper<Order, OrderDTO> {

    private OrderRepository orderRepository;
    private ClientRepository clientRepository;
    @Override
    public OrderDTO entityToDTO(Order entity) {
        return OrderDTO.builder()
                .orderId(entity.getOrderId())
                .orderDate(entity.getOrderDate())
                .deliveryDate(entity.getDeliveryDate())
                .orderNumber(entity.getOrderNumber())
                .orderStatus(entity.getOrderStatus().name())
                .totalPrice(entity.getTotalPrice())
//                .clientDTOemail(entity.getClient().getEmail())
                .build();
    }

    @Override
    public Order DTOToEntity(OrderDTO dto) {
        Order order = orderRepository.findByOrderNumber(dto.getOrderNumber()).orElse(new Order());
//        Client client = clientRepository.findByEmail(dto.getClientDTOemail()).orElseThrow(()-> new NotFoundException("Client not found."));
        order.setShoppingCart(dto.getShoppingCartDTO());
        order.setOrderDate(dto.getOrderDate());
        order.setDeliveryDate(dto.getDeliveryDate());
        order.setOrderNumber(dto.getOrderNumber());
        order.setDiscount(0);
        order.setTotalPrice(dto.getTotalPrice());
        order.setOrderStatus(OrderStatus.valueOf(dto.getOrderStatus().toUpperCase()));
//        order.setClient(client);
        return order;
    }

    private Integer generateOrderNumber() {
        Random number = new Random();
        Integer orderNumber = number.nextInt(100000,999999);
        return orderNumber;
    }
}
