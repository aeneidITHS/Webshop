package com.example.webshopping.data;

import com.example.webshopping.bussiness.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRepository  extends JpaRepository<Admin,Long> {
    List<Admin> findByNameAndPassword(String name, String password);
}
