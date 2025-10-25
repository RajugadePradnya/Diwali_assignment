package com.example.ecommerce.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    private String id = UUID.randomUUID().toString();

    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String email;

    private String password; // hashed

    private String address;
    private String phoneNumber;

    public Customer(){}

    // getters and setters
    public String getId(){ return id; }
    public void setId(String id){ this.id = id; }

    public String getFirstName(){ return firstName; }
    public void setFirstName(String fn){ this.firstName = fn; }

    public String getLastName(){ return lastName; }
    public void setLastName(String ln){ this.lastName = ln; }

    public String getEmail(){ return email; }
    public void setEmail(String e){ this.email = e; }

    public String getPassword(){ return password; }
    public void setPassword(String p){ this.password = p; }

    public String getAddress(){ return address; }
    public void setAddress(String a){ this.address = a; }

    public String getPhoneNumber(){ return phoneNumber; }
    public void setPhoneNumber(String p){ this.phoneNumber = p; }
}
