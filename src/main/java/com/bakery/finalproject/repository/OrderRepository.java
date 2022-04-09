package com.bakery.finalproject.repository;

import com.bakery.finalproject.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
    @Query("Select o from Order o where o.orderNumber = :on")
    public Optional<Order> findByOrderNumber(@Param("on") Integer orderNumber);
}
