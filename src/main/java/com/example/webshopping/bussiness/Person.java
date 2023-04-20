package com.example.webshopping.bussiness;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Person {
    @Id
    @SequenceGenerator(name = "my_entity_gen", sequenceName = "my_entity_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "my_entity_gen")
    private Long id;
    @NotBlank
    private String userName;



    @NotBlank
    private String password;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<CustomerOrder> customerOrders;

    public Person() {

    }

    public Person(String userName, String password) {
        this.userName = userName;
        this.password = password;
        customerOrders = new ArrayList<>();
    }


    public void addOrder(CustomerOrder customerOrder){
        customerOrders.add(customerOrder);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setCustomerOrders(List<CustomerOrder> customerOrders) {
        this.customerOrders = customerOrders;
    }
}
