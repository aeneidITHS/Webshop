package com.example.webshopping.data;

import com.example.webshopping.bussiness.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findProductsByCategory(String category);
    Product findByName(String name);
    Product findByPrice(Double price);
}
