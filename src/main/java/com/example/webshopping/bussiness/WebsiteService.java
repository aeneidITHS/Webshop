package com.example.webshopping.bussiness;

import com.example.webshopping.data.OrderRepository;
import com.example.webshopping.data.PersonRepository;
import com.example.webshopping.data.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

@Service
@SessionScope
public class WebsiteService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    OrderRepository orderRepository;
    boolean exists = false;
    Person person;
    Product product;
    Cart cart;

    WebsiteService(){
        cart = new Cart();
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    public List<Person> getAllPeople(){
       return personRepository.findAll();
    }
    public Product getProductById(long id){
        return productRepository.findById(id).get();
    }
    public Person Login(String loginName, String password){
        List<Person> personList = personRepository.findByEmailAndPassword(loginName,password);
        person = personList.get(0);
        return person;
    }
    public String checkIfUserExist(String loginName, String password){
        List<Person> personList = personRepository.findByEmailAndPassword(loginName,password);
        if (personList.isEmpty()){
            person=personRepository.save(new Person(loginName,password));
            return "Created new user!";
        }
        return "User exists";
    }
    public Person adminLogin(String loginName,String password){

    }

    public Product addProductToDB(String productName,String productCategory,Double productPrice){
        product = productRepository.save(new Product(productName,productPrice,productCategory));
        return product;
    }


}
