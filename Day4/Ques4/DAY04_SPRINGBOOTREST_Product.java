package com.example.productapi.model;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    @ManyToOne @JoinColumn(name="category_id")
    private Category category;
    public Product() {}
    public Product(String name,double price,Category c){this.name=name;this.price=price;this.category=c;}
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getName(){return name;} public void setName(String name){this.name=name;}
    public double getPrice(){return price;} public void setPrice(double price){this.price=price;}
    public Category getCategory(){return category;} public void setCategory(Category c){this.category=c;}
}
