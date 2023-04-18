package com.example.webshopping.bussiness;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<CartItem> cartItems;

    @ManyToOne
    Person person;

    public CustomerOrder(List<CartItem> cartItems, Person person) {
    this.cartItems =cartItems;
    this.person = person;
    }

    public CustomerOrder() {

    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }
}
