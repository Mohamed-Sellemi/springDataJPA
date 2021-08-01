package com.formation.spring.data.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.formation.spring.data.exception.ModelNotExisteException;
import com.formation.spring.data.model.Product;
import com.formation.spring.data.repository.ProductRepository;

@Service
public final class ProductService {
    
    @Autowired
    private ProductRepository repository;
    
    public Product save(Product product) throws ModelNotExisteException {
        if (product == null) {
            throw new ModelNotExisteException("Le Produit ne doit pas être null");
        }
        
        return repository.save(product);
        
    }
    
    public Product find(int productId) {
        return repository.findById(productId).map(p -> p).orElse(null);
    }
    
    public List<Product> findAll() {
        return repository.findAll();
    }
    
    public void delete(int productId) throws ModelNotExisteException {
        Product product = this.find(productId);
        if (product == null) {
            throw new ModelNotExisteException("pas de produit correspondant à ce productId: " + productId);
        }
        
        repository.delete(product);
    }
    
    public void update(Product product) throws ModelNotExisteException {
        if (product == null) {
            throw new NullPointerException("Le product ne peut pas être null");
        }
        Product prod = this.find(product.getProductId());
        if (prod == null) {
            throw new ModelNotExisteException("pas de produit correspondant à ce productId: " + product.getProductId());
        }
        prod.setCost(product.getCost());
        prod.setDescription(product.getDescription());
        prod.setName(product.getName());
        repository.save(prod);
    }
    
    public Page<Product> findAllWithPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.findAll(pageable);
        
    }
    
    public Page<Product> findAlldWithPaginationAndSorting(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("name").descending().and(Sort.by("cost")));
        return repository.findAll(pageable);
    }
    
    public List<Product> getProductWithCost(int page, int size, int cost) {
        return repository.findAllByCost(cost, PageRequest.of(page, size));
    }
    
}
