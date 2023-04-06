package com.example.webshopping.bussiness;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Entity
@Table(name = "admin")
public class Admin  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String password;

    private int clearance;



    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
