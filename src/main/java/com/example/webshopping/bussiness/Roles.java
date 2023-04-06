package com.example.webshopping.bussiness;

import jakarta.persistence.*;

@Entity
@Table(name = "role")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id",nullable = false)
    private Integer id;

    private String name;
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
