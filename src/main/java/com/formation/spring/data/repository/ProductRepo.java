package com.formation.spring.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formation.spring.data.entities.Product;

public interface ProductRepo extends JpaRepository<Product, String> {
    
}
