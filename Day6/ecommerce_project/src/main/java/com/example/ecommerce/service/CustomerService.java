package com.example.ecommerce.service;

import com.example.ecommerce.model.Customer;
import com.example.ecommerce.repository.CustomerRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository repo;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public CustomerService(CustomerRepository repo){
        this.repo = repo;
    }

    public Customer register(Customer c){
        c.setPassword(encoder.encode(c.getPassword()));
        return repo.save(c);
    }

    public Optional<Customer> findById(String id){ return repo.findById(id); }
    public List<Customer> findAll(){ return repo.findAll(); }
    public Customer update(String id, Customer updates){
        return repo.findById(id).map(existing -> {
            existing.setFirstName(updates.getFirstName());
            existing.setLastName(updates.getLastName());
            existing.setAddress(updates.getAddress());
            existing.setPhoneNumber(updates.getPhoneNumber());
            // do not override email/password unless provided
            if(updates.getEmail()!=null) existing.setEmail(updates.getEmail());
            if(updates.getPassword()!=null && !updates.getPassword().isEmpty())
                existing.setPassword(encoder.encode(updates.getPassword()));
            return repo.save(existing);
        }).orElse(null);
    }
    public void delete(String id){ repo.deleteById(id); }

    public Optional<Customer> findByEmail(String email){ return repo.findByEmail(email); }
}
