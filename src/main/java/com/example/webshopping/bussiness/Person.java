package com.example.webshopping.bussiness;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id",nullable = false)
    private Long id;
    @NotBlank
    @Email
    private String email;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<CustomerOrder> customerOrders;
    @NotBlank
    private String password;
    public Person(String email,String password){
        this.email = email;
        this.password = password;
        customerOrders = new ArrayList<>();
    }
    public  Person(String email,String password,Long id,List<CustomerOrder> customerOrders){
        this.customerOrders = customerOrders;
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
