package com.formation.spring.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categorie")
public final class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categorie_id")
    private int categoryId;
    @Column(name = "nom")
    private String name;
    
//    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
//    @JoinTable(name = "categorie_produit", joinColumns = @JoinColumn(name = "categorie_id"), inverseJoinColumns = @JoinColumn(name = "produit_id"))
//    private List<Product> products = new ArrayList<>();
    
    public int getCategoryId() {
        return categoryId;
    }
    
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return "Category [categoryId=" + categoryId + ", name=" + name + "]";
    }
    
//    public List<Product> getProducts() {
//        return products;
//    }
//    
//    public void setProducts(List<Product> products) {
//        this.products = products;
//    }
//    
//    @Override
//    public String toString() {
//        return "Category [categoryId=" + categoryId + ", name=" + name + ", products=" + products + "]";
//    }
    
}
