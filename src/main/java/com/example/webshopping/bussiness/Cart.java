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

    public void removeItemFromCart(int id){
        if (cartItems.get(id).getAmount()==1){
            cartItems.remove(id);
        }
        else {
            cartItems.get(id).removeOneFromAmount();
        }
    }
    public Double sumOfWholeCart(){
        double temp = 0.0;
        for(CartItem cartItem : cartItems){
            temp +=(int) (cartItem.product.getPrice() *cartItem.amount);
        }
        return temp;
    }
}
