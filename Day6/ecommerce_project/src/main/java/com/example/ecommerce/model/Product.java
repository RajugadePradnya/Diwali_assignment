package com.example.ecommerce.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "products")
public class Product {
    @Id
    private String id = UUID.randomUUID().toString();

    private String name;
    @Column(length = 2000)
    private String description;
    private BigDecimal price;
    private Integer quantity;
    private String category;

    public Product(){}

    // getters and setters
    public String getId(){ return id; }
    public void setId(String id){ this.id = id; }

    public String getName(){ return name; }
    public void setName(String n){ this.name = n; }

    public String getDescription(){ return description; }
    public void setDescription(String d){ this.description = d; }

    public BigDecimal getPrice(){ return price; }
    public void setPrice(BigDecimal p){ this.price = p; }

    public Integer getQuantity(){ return quantity; }
    public void setQuantity(Integer q){ this.quantity = q; }

    public String getCategory(){ return category; }
    public void setCategory(String c){ this.category = c; }
}
