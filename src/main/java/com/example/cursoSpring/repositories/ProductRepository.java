package com.example.cursoSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cursoSpring.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
