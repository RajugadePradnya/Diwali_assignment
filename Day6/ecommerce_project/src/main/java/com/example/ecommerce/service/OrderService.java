package com.example.ecommerce.service;

import com.example.ecommerce.model.*;
import com.example.ecommerce.repository.OrderRepository;
import com.example.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepo;
    private final ProductRepository productRepo;

    public OrderService(OrderRepository orderRepo, ProductRepository productRepo){
        this.orderRepo = orderRepo;
        this.productRepo = productRepo;
    }

    public Order placeOrder(Order order){
        // calculate total and adjust product quantities
        BigDecimal total = BigDecimal.ZERO;
        for(OrderItem item : order.getOrderItems()){
            Optional<Product> p = productRepo.findById(item.getProductId());
            if(p.isPresent()){
                Product prod = p.get();
                if(prod.getQuantity() < item.getQuantity()){
                    throw new RuntimeException("Insufficient stock for product: " + prod.getName());
                }
                prod.setQuantity(prod.getQuantity() - item.getQuantity());
                productRepo.save(prod);
                item.setProductName(prod.getName());
                item.setPrice(prod.getPrice());
                total = total.add(prod.getPrice().multiply(new BigDecimal(item.getQuantity())));
            } else {
                throw new RuntimeException("Product not found: " + item.getProductId());
            }
        }
        order.setTotalAmount(total);
        return orderRepo.save(order);
    }

    public Optional<Order> findById(String id){ return orderRepo.findById(id); }
    public List<Order> findByCustomerId(String customerId){ return orderRepo.findByCustomerId(customerId); }
    public List<Order> findAll(){ return orderRepo.findAll(); }
    public Order updateStatus(String id, OrderStatus status){
        return orderRepo.findById(id).map(o -> { o.setStatus(status); return orderRepo.save(o); }).orElse(null);
    }
    public void cancelOrder(String id){
        orderRepo.findById(id).ifPresent(o -> {
            o.setStatus(OrderStatus.CANCELLED);
            // NOTE: not restoring stock here for simplicity
            orderRepo.save(o);
        });
    }
}
