package com.example.webshopping.bussiness;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String name;
    private String category;
    private Double price;

    public Product(){

    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public Double getPrice() {
        return price;
    }

    public Product(String name, Double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Product(Long id, String name, String category, Double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }
}
