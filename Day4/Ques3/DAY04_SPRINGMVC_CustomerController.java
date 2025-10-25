package com.example.customermgmt.controller;

import com.example.customermgmt.model.Customer;
import com.example.customermgmt.repo.CustomerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerRepository repo;
    public CustomerController(CustomerRepository repo) { this.repo = repo; }

    @GetMapping
    public String list(Model m) { m.addAttribute("customers", repo.findAll()); return "customers/list"; }

    @GetMapping("/new")
    public String createForm(Model m) { m.addAttribute("customer", new Customer()); return "customers/form"; }

    @PostMapping("/save")
    public String save(Customer customer) { repo.save(customer); return "redirect:/customers"; }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model m) { m.addAttribute("customer", repo.findById(id).orElse(new Customer())); return "customers/form"; }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) { repo.deleteById(id); return "redirect:/customers"; }
}
