package com.example.productapi.repo;
import com.example.productapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface ProductRepo extends JpaRepository<Product,Long> {
    List<Product> findByPriceBetween(double low,double high);
}
