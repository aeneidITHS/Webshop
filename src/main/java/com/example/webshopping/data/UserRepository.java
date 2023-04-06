package com.example.webshopping.data;

import com.example.webshopping.bussiness.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User>findByEmail(String email);

    List<User> findByEmailAndPassword(String email, String password);
    User getUserByUserName(@Param("username") String userName);
}
