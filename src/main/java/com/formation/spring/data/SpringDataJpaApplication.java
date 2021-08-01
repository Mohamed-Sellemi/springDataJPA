package com.formation.spring.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.formation.spring.data.metier.ProductService;
import com.formation.spring.data.model.Product;

@SpringBootApplication
public class SpringDataJpaApplication implements CommandLineRunner {
    
    @Autowired
    private ProductService service;
    
    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);
    }
    
    @Override
    public void run(String... args) throws Exception {
        Product p1 = new Product();
        p1.setCost(500);
        p1.setName("test hameda");
        p1.setDescription("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
        service.save(p1);
        service.getProductWithCost(0, 1, 500).forEach(System.out::println);
        System.out.println("*************************");
        service.getProductWithCost(1, 1, 500).forEach(System.out::println);
        service.delete(5);
        
//        Page<Product> pages = service.findAlldWithPaginationAndSorting(0, 2);
//        System.out.println("Count Page: " + pages.getSize());
//        pages.forEach(System.out::println);
//        System.out.println("*************************");
//        Page<Product> pages1 = service.findAlldWithPaginationAndSorting(1, 2);
//        pages1.forEach(System.out::println);
        
    }
    
}
