package com.example.ecommerce.controller;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService service;
    public ProductController(ProductService service){ this.service = service; }

    @PostMapping
    public ResponseEntity<Product> add(@RequestBody Product p){ return ResponseEntity.ok(service.save(p)); }

    @GetMapping("/{id}")
    public ResponseEntity<Product> get(@PathVariable String id){
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Product> listAll(){ return service.findAll(); }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable String id, @RequestBody Product updates){
        Product u = service.update(id, updates);
        if(u==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(u);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public List<Product> search(@RequestParam(required=false) String name, @RequestParam(required=false) String category){
        if(name!=null) return service.searchByName(name);
        if(category!=null) return service.findByCategory(category);
        return service.findAll();
    }
}
