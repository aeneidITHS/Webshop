package com.example.webshopping.bussiness;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    List<CartItem> cartItems;
    public Cart(){
        this.cartItems = new ArrayList<>();
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public List<CartItem> removeItemFromCart(int id){
        if (cartItems.get(id).getAmount()==1){
            getCartItems().remove(id);
        }
        else {
            getCartItems().get(id).removeOneFromAmount();
        }
        return getCartItems();
    }
    public Double sumOfWholeCart(){
        double temp = 0.0;
        for(CartItem cartItem : cartItems){
            temp +=(int) (cartItem.product.getPrice() *cartItem.amount);
        }
        return temp;
    }
}
