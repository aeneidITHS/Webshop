package com.example.webshopping.data;

import com.example.webshopping.bussiness.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User>findByUserName(String username);

    List<User> findByUserNameAndPassword(String UserName, String Password);
    User getUserByUserName(@Param("UserName") String userName);
}
