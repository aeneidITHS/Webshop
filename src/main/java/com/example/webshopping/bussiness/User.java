package com.example.webshopping.bussiness;

import com.example.webshopping.Security.Roles;
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
    private String userName;
    private boolean enabled;
    @NotBlank
    @Column(name = "PASSWORD",nullable = false)
    private String password;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Roles> roles = new HashSet<>();
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<CustomerOrder> customerOrders;


    public User(String userName, String password){
        this.userName = userName;
        this.password = password;
        customerOrders = new ArrayList<>();
    }
    public User(String userName, String password, Long id, List<CustomerOrder> customerOrders){
        this.customerOrders = customerOrders;
        this.id = id;
        this.userName = userName;
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

    public Set<Roles> getRoles() {
        return roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
