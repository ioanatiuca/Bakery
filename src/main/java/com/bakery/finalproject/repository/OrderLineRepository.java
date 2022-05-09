package com.bakery.finalproject.repository;

import com.bakery.finalproject.entity.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderLineRepository extends JpaRepository<OrderLine, Integer> {

    @Query("select ol from OrderLine ol inner join Order o on ol.orderLineId=o.orderId")
    List<OrderLine> findAllByOrderId(Integer orderId);
}
