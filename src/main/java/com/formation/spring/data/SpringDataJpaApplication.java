package com.formation.spring.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.formation.spring.data.metier.ProductService;

@SpringBootApplication
public class SpringDataJpaApplication implements CommandLineRunner {
    
    @Autowired
    private ProductService service;
    
    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);
    }
    
    @Override
    public void run(String... args) throws Exception {
        service.find(1).getComments().forEach(System.out::println);
        
    }
    
}
