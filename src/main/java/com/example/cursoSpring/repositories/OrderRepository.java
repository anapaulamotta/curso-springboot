package com.example.cursoSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cursoSpring.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long  	>{

}
