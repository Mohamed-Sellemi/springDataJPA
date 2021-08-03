package com.formation.spring.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.formation.spring.data.metier.ProductService;
import com.formation.spring.data.repository.CategoryRepository;
import com.formation.spring.data.repository.CommentRepository;

@SpringBootApplication
public class SpringDataJpaApplication implements CommandLineRunner {
    
    @Autowired
    private ProductService service;
    @Autowired
    private CategoryRepository repo;
    
    @Autowired
    private CommentRepository repoC;
    
    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);
    }
    
    @Transactional
    @Override
    public void run(String... args) throws Exception {
        
//        Product p1 = new Product();
//        p1.setCost(600);
//        p1.setDescription("test1");
//        p1.setName("test1");
//        service.save(p1);
//        Category c1 = new Category();
//        c1.setName("C1");
//        
//        c1.addProduct(p1);
//        repo.save(c1);
//        
//        service.update(p1);
    
//        Product p2 = new Product();
//        p2.setCost(500);
//        p2.setDescription("test2 Description");
//        p2.setName("P50");
//        service.save(p2);
//        
//        Comment co1 = new Comment();
//        co1.setContent("P50 est idéal pour les cheveux");
//        
//        p2.addComment(co1);
//        repoC.save(co1);
    
//        Product p1 = service.find(9);
//        p1.setCost(800);
//        service.save(p1);
        
        service.getAllProductWithNameCategory("Standard").forEach(product -> System.out.println(product.getName()));
    }
    
}
