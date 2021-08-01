package com.formation.spring.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.formation.spring.data.metier.ProductService;
import com.formation.spring.data.repository.CategoryRepository;

@SpringBootApplication
public class SpringDataJpaApplication implements CommandLineRunner {
    
    @Autowired
    private ProductService service;
    @Autowired
    private CategoryRepository repo;
    
    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);
    }
    
    @Transactional
    @Override
    public void run(String... args) throws Exception {
        service.find(1).getComments().forEach(System.out::println);
        repo.findById(1).get().getProducts().forEach(System.out::println);
    }
    
}
