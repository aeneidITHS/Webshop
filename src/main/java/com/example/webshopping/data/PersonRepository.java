package com.example.webshopping.data;

import com.example.webshopping.bussiness.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person,Long> {
    Optional<Person>findByEmail(String email);

    List<Person> findByEmailAndPassword(String email,String password);
}
