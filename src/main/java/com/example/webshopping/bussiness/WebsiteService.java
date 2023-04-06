package com.example.webshopping.bussiness;

import com.example.webshopping.data.AdminRepository;
import com.example.webshopping.data.OrderRepository;
import com.example.webshopping.data.UserRepository;
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
    UserRepository userRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    AdminRepository adminRepository;
    boolean exists = false;
    boolean currentUserIsAdmin = false;
    User user;
    Admin admin;
    Product product;
    Cart cart;

    WebsiteService(){
        cart = new Cart();
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    public List<User> getAllPeople(){
       return userRepository.findAll();
    }
    public Product getProductById(long id){
        return productRepository.findById(id).get();
    }
    public User Login(String loginName, String password){
        List<User> userList = userRepository.findByEmailAndPassword(loginName,password);
        user = userList.get(0);
        return user;
    }
    public String checkIfUserExist(String loginName, String password){
        List<User> userList = userRepository.findByEmailAndPassword(loginName,password);
        if (userList.isEmpty()){
            user = userRepository.save(new User(loginName,password));
            return "Created new user!";
        }
        return "User exists";
    }
    public Admin adminLogin(String loginName,String password){
        List<Admin> adminList = adminRepository.findByNameAndPassword(loginName,password);
        admin = adminList.get(0);
        currentUserIsAdmin = true;
        return admin;
    }

    public Product addProductToDB(String productName,String productCategory,Double productPrice){
        product = productRepository.save(new Product(productName,productPrice,productCategory));
        return product;
    }

    public

}
