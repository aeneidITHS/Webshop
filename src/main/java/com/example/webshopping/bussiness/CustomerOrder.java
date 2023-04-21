package com.example.webshopping.bussiness;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<CartItem> cartItems;



    private boolean sent;
    @ManyToOne
    Person person;

    public CustomerOrder(List<CartItem> cartItems, Person person) {
    this.cartItems =cartItems;
    this.person = person;
    }

    public CustomerOrder() {

    }
    public boolean isSent() {
        return sent;
    }

    public void setSent(boolean sent) {
        this.sent = sent;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public Long getId() {
        return id;
    }
}
