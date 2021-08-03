package com.formation.spring.data.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.formation.spring.data.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    public List<Product> findAllByCost(int cost, Pageable pageable);
    
    public List<Product> findByName(String name);
    
    public List<Product> findByCategoriesName(String name);
    
    @Query("FROM Product WHERE name = ?1")
    public Iterable<Product> findByNameJPQL(String name);
    
    @Query(value = "SELECT * FROM produit WHERE cout = :cout", nativeQuery = true)
    public Iterable<Product> findByCostNative(@Param("cout") Integer cost);
}
