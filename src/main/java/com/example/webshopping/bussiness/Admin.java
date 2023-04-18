package com.example.webshopping.bussiness;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.boot.context.properties.bind.DefaultValue;


public class Admin  {


    private final String name;

    private final String password;

    public Admin() {
        this.name = "admin";
        this.password = "admin";
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
