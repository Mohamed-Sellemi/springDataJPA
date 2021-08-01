package com.formation.spring.data;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.formation.spring.data.entities.Categ;
import com.formation.spring.data.entities.Product;
import com.formation.spring.data.repository.CategorieRepo;
import com.formation.spring.data.repository.ProductRepo;

@SpringBootApplication
public class SpringDataJpaApplication implements CommandLineRunner {
    
    @Autowired
    private ProductRepo productRepo;
    
    @Autowired
    private CategorieRepo categRepo;
    
    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);
    }
    
    @Override
    public void run(String... args) throws Exception {
        Categ c1 = new Categ("C1", null);
        Categ c2 = new Categ("C2", null);
        Categ c3 = new Categ("C3", null);
        
        categRepo.save(c1);
        categRepo.save(c2);
        categRepo.save(c3);
        
        Product p1 = new Product("p1", "desc1", 10, Arrays.asList(c1, c2));
        
        Product p2 = new Product("p2", "desc2", 20, Arrays.asList(c1, c3));
        productRepo.save(p1);
        productRepo.save(p2);
    }
    
}
