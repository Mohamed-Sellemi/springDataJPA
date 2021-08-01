package com.formation.spring.data.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    
    public void update(Product product) {
        Product prod = this.find(product.getProductId());
        prod.setCost(product.getCost());
        prod.setDescription(product.getDescription());
        prod.setName(product.getName());
        repository.save(prod);
    }
    
}
