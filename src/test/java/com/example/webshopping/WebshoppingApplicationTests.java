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
        websiteService.addProductToDB(product.getName(), product.getCategory(), product.getPrice());
        websiteService.addProductToDB(product2.getName(), product2.getCategory(), product2.getPrice());
        websiteService.addProductToDB(product3.getName(), product3.getCategory(), product3.getPrice());
        websiteService.addProductIntoCart(1L, 2);
        websiteService.addProductIntoCart(2L, 4);
        websiteService.addProductIntoCart(3L, 2);
    }

    @Test
    void clearCartTest() {
        websiteService.clearCart();
        assertEquals(0, websiteService.getCart().getCartItems().size());
    }

    @Test
    void addToCartTest() {
        assertEquals(3, websiteService.getCart().getCartItems().size());
    }

    @Test
    void removeItemFromCartTest() {
        websiteService.getCart().removeItemFromCart(0);
        assertEquals(1, websiteService.getCart().getCartItems().size());
    }


}
