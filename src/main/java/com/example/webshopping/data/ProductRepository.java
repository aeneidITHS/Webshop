package com.example.webshopping.data;

import com.example.webshopping.bussiness.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findProductsByCategory(String category);
    List<Product> findByName(String name);
    List<Product> findByPrice(Double price);

}
