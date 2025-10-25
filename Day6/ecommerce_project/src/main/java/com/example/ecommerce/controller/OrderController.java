package com.example.ecommerce.controller;

import com.example.ecommerce.model.*;
import com.example.ecommerce.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService service;
    public OrderController(OrderService service){ this.service = service; }

    @PostMapping
    public ResponseEntity<?> place(@RequestBody Order order){
        try {
            Order saved = service.placeOrder(order);
            return ResponseEntity.ok(saved);
        } catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> get(@PathVariable String id){
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/customer/{customerId}")
    public List<Order> listByCustomer(@PathVariable String customerId){
        return service.findByCustomerId(customerId);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Order> updateStatus(@PathVariable String id, @RequestParam OrderStatus status){
        Order o = service.updateStatus(id, status);
        if(o==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(o);
    }

    @PostMapping("/{id}/cancel")
    public ResponseEntity<Void> cancel(@PathVariable String id){
        service.cancelOrder(id);
        return ResponseEntity.noContent().build();
    }
}
