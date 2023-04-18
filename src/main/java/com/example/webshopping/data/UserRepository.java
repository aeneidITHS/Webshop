package com.example.webshopping.data;

import com.example.webshopping.bussiness.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Person,Long> {
    List<Person>findByUserName(String userName);

    List<Person> findByUserNameAndPassword(String userName, String password);
    //UserOld getUserByUserName(@Param("UserName") String userName);
}
