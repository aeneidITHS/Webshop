package com.example.webshopping.data;

import com.example.webshopping.bussiness.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    List<User>findByUserName(String userName);

    List<User> findByUserNameAndPassword(String userName, String password);
    //User getUserByUserName(@Param("UserName") String userName);
}
