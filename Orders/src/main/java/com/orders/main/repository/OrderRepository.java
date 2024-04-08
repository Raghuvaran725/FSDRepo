package com.orders.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.order.main.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer> {

}
