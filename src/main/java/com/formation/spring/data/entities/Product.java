package com.formation.spring.data.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity

public class Product implements Serializable {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String productId;
    @Column(length = 50)
    private String nom;
    private String description;
    private int cout;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "Categ-Product", joinColumns = { @JoinColumn(name = "product-id") }, inverseJoinColumns = {
            @JoinColumn(name = "categ-id") })
    private List<Categ> categories;
    
    public Product() {
        
    }
    
    public Product(String nom, String description, int cout, List<Categ> categories) {
        super();
        this.nom = nom;
        this.description = description;
        this.cout = cout;
        this.categories = categories;
    }
    
    public String getProductId() {
        return productId;
    }
    
    public void setProductId(String productId) {
        this.productId = productId;
    }
    
    public String getNom() {
        return nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public int getCout() {
        return cout;
    }
    
    public void setCout(int cout) {
        this.cout = cout;
    }
    
    public List<Categ> getCategories() {
        return categories;
    }
    
    public void setCategories(List<Categ> categories) {
        this.categories = categories;
    }
    
    @Override
    public String toString() {
        return "Product [productId=" + productId + ", nom=" + nom + ", description=" + description + ", cout=" + cout
                + ", categories=" + categories + "]";
    }
    
}
