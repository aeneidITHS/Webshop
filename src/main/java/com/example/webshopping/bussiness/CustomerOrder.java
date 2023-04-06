package com.example.webshopping.bussiness;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<CartItem> cartItems;

    @ManyToOne
    User user;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
