package com.example.ecommerce.controller;

import com.example.ecommerce.model.Customer;
import com.example.ecommerce.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService service;
    public CustomerController(CustomerService service){ this.service = service; }

    @PostMapping("/register")
    public ResponseEntity<Customer> register(@RequestBody Customer c){
        return ResponseEntity.ok(service.register(c));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getById(@PathVariable String id){
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Customer> listAll(){ return service.findAll(); }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> update(@PathVariable String id, @RequestBody Customer updates){
        Customer updated = service.update(id, updates);
        if(updated==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
