package com.example.ecommerce.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    private String orderId = UUID.randomUUID().toString();

    private String customerId;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="order_id")
    private List<OrderItem> orderItems = new ArrayList<>();

    private BigDecimal totalAmount;
    private Instant orderDate = Instant.now();

    @Enumerated(EnumType.STRING)
    private OrderStatus status = OrderStatus.PENDING;

    public Order(){}

    // getters and setters
    public String getOrderId(){ return orderId; }
    public void setOrderId(String id){ this.orderId = id; }

    public String getCustomerId(){ return customerId; }
    public void setCustomerId(String cid){ this.customerId = cid; }

    public List<OrderItem> getOrderItems(){ return orderItems; }
    public void setOrderItems(List<OrderItem> items){ this.orderItems = items; }

    public BigDecimal getTotalAmount(){ return totalAmount; }
    public void setTotalAmount(BigDecimal t){ this.totalAmount = t; }

    public Instant getOrderDate(){ return orderDate; }
    public void setOrderDate(Instant d){ this.orderDate = d; }

    public OrderStatus getStatus(){ return status; }
    public void setStatus(OrderStatus s){ this.status = s; }
}
