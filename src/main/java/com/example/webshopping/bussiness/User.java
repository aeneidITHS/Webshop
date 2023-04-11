package com.example.webshopping.bussiness;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id",nullable = false)
    private Long id;
    @NotBlank
    @Column(name = "USERNAME",nullable = false,unique = true)
    private String username;
    private boolean enabled;
    @NotBlank
    @Column(name = "PASSWORD",nullable = false)
    private String password;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<CustomerOrder> customerOrders;


    public User(String username, String password){
        this.username = username;
        this.password = password;
        customerOrders = new ArrayList<>();
    }
    public User(String username, String password, Long id, List<CustomerOrder> customerOrders){
        this.customerOrders = customerOrders;
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public boolean isEnabled() {
        return enabled;
    }
    public void addOrder(CustomerOrder customerOrder){
        customerOrders.add(customerOrder);
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
