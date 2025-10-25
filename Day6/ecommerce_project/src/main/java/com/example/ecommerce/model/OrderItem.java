package com.example.ecommerce.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "order_items")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productId;
    private String productName;
    private Integer quantity;
    private BigDecimal price; // price per unit

    public OrderItem(){}

    // getters and setters
    public Long getId(){ return id; }
    public void setId(Long id){ this.id = id; }

    public String getProductId(){ return productId; }
    public void setProductId(String pid){ this.productId = pid; }

    public String getProductName(){ return productName; }
    public void setProductName(String pn){ this.productName = pn; }

    public Integer getQuantity(){ return quantity; }
    public void setQuantity(Integer q){ this.quantity = q; }

    public BigDecimal getPrice(){ return price; }
    public void setPrice(BigDecimal p){ this.price = p; }
}
