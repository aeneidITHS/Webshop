package com.example.webshopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@ComponentScan(basePackages ={"com.example.webshopping.bussiness"} )
@EnableJpaRepositories("com.example.webshopping.data")

public class WebshoppingApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebshoppingApplication.class, args);
    }

}
