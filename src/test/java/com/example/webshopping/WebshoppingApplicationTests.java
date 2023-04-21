package com.example.webshopping;

import com.example.webshopping.bussiness.CartItem;
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

    @BeforeEach
    void setUp() {
        websiteService.addProductIntoCart(1L,1);
        websiteService.addProductIntoCart(2L,2);
        websiteService.addProductIntoCart(3L,3);
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
    void removeFromCartTest() {
        websiteService.getCart().removeItemFromCart(0);
        assertEquals(2,websiteService.getCart().getCartItems().get(0).getAmount());
    }


}
