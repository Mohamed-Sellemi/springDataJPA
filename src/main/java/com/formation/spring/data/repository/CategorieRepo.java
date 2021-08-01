package com.formation.spring.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formation.spring.data.entities.Categ;

public interface CategorieRepo extends JpaRepository<Categ, String> {
    
}
