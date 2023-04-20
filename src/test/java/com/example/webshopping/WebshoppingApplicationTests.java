package com.example.webshopping;

import com.example.webshopping.bussiness.Product;
import com.example.webshopping.bussiness.WebsiteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class WebshoppingApplicationTests {
    @Autowired
    WebsiteService websiteService;
    Product product = Mockito.mock(Product.class);
    Product product2 = Mockito.mock(Product.class);
    Product product3 = Mockito.mock(Product.class);

    @BeforeEach
    void setUp() {
        websiteService.addProductToDB(product.getName(), product.getPrice(), product.getCategory());
        websiteService.addProductToDB(product2.getName(), product2.getPrice(), product2.getCategory());
        websiteService.addProductToDB(product3.getName(), product3.getPrice(), product3.getCategory());
        websiteService.addProductIntoCart(1L, 2);
        websiteService.addProductIntoCart(2L, 4);
        websiteService.addProductIntoCart(3L, 2);
    }

}
