package com.example.cursoSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cursoSpring.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
