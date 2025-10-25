package com.example.ecommerce.service;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository repo;
    public ProductService(ProductRepository repo){ this.repo = repo; }

    public Product save(Product p){ return repo.save(p); }
    public Optional<Product> findById(String id){ return repo.findById(id); }
    public List<Product> findAll(){ return repo.findAll(); }
    public Product update(String id, Product updates){
        return repo.findById(id).map(existing -> {
            existing.setName(updates.getName());
            existing.setDescription(updates.getDescription());
            existing.setPrice(updates.getPrice());
            existing.setQuantity(updates.getQuantity());
            existing.setCategory(updates.getCategory());
            return repo.save(existing);
        }).orElse(null);
    }
    public void delete(String id){ repo.deleteById(id); }
    public List<Product> searchByName(String name){ return repo.findByNameContainingIgnoreCase(name); }
    public List<Product> findByCategory(String category){ return repo.findByCategoryIgnoreCase(category); }
}
