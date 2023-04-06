package com.example.webshopping.data;

import com.example.webshopping.bussiness.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
