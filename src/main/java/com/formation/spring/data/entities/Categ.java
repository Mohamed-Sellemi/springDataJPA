package com.formation.spring.data.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity

public class Categ implements Serializable {
    
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "categorie_id")
    private String categorieId;
    private String nom;
    @ManyToMany(mappedBy = "categories", cascade = CascadeType.ALL)
    private List<Product> products;
    
    public Categ() {
        
    }
    
    public Categ(String nom, List<Product> products) {
        
        this.nom = nom;
        this.products = products;
    }
    
    public String getCategorieId() {
        return categorieId;
    }
    
    public void setCategorieId(String categorieId) {
        this.categorieId = categorieId;
    }
    
    public String getNom() {
        return nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public List<Product> getProducts() {
        return products;
    }
    
    public void setProducts(List<Product> products) {
        this.products = products;
    }
    
    @Override
    public String toString() {
        return "Categorie [categorieId=" + categorieId + ", nom=" + nom + ", products=" + products + "]";
    }
    
}
