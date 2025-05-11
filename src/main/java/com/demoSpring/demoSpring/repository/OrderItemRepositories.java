package com.demoSpring.demoSpring.repository;

import com.demoSpring.demoSpring.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepositories extends JpaRepository<OrderItem,Long> {
}
