package com.example.productapi.controller;

import com.example.productapi.model.Product;
import com.example.productapi.repo.ProductRepo;
import com.example.productapi.repo.CategoryRepo;
import com.example.productapi.model.Category;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    private final ProductRepo prepo; private final CategoryRepo crepo;
    public ProductController(ProductRepo prepo, CategoryRepo crepo){ this.prepo = prepo; this.crepo = crepo; }

    @GetMapping("/products")
    public List<Product> all(){ return prepo.findAll(); }

    @PostMapping("/products")
    public Product add(@RequestBody Product p){ return prepo.save(p); }

    @GetMapping("/products/price-range")
    public List<Product> byPrice(@RequestParam double low, @RequestParam double high) {
        return prepo.findByPriceBetween(low, high);
    }

    @PutMapping("/products/{id}/price")
    public Product updatePrice(@PathVariable Long id, @RequestBody double newPrice) {
        Product p = prepo.findById(id).orElseThrow();
        p.setPrice(newPrice);
        return prepo.save(p);
    }
}
