package com.example.webshopping.bussiness;

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
    public List<Product> findProductByCategory(String category){
        return productRepository.findProductsByCategory(category);
    }
    public Product findProductByName(String name){
        return productRepository.findByName(name);
    }
    public Product findProductByPrice(Double price){
        return productRepository.findByPrice(price);
    }
    public User Login(String loginName, String password){
        List<User> userList = userRepository.findByUserNameAndPassword(loginName,password);
        user = userList.get(0);
        return user;
    }
    public String checkIfUserExist(String loginName, String password){
        List<User> userList = userRepository.findByUserNameAndPassword(loginName,password);
        if (userList.isEmpty()){
            user = new User(loginName,password);
            user = userRepository.save(user);
            return "Created new user!";
        }
        return "User exists";
    }
    public Admin adminLogin(String loginName,String password){
        if (loginName.equalsIgnoreCase(admin.getName())&&password.equalsIgnoreCase(admin.getPassword())){
            currentUserIsAdmin = true;
            return admin;
        }
        else {
            return null;
        }
    }

    public Cart getCart() {
        return cart;
    }

    public Product addProductToDB(String productName, String productCategory, Double productPrice){
        product = productRepository.save(new Product(productName,productPrice,productCategory));
        return product;
    }

    public Cart addProductIntoCart(Long id, int amount){
        cart.cartItems.add(new CartItem(getProductById(id),amount));
        return cart;
    }
    public String addCustomerOrder(){
        user.addOrder(new CustomerOrder(getCart().getCartItems(),user));
        user = userRepository.save(user);
        return "Order has been sent!";
    }
    public void clearCart(){
        cart = new Cart();
    }

    public String removeFromCart(int id){
        cart.removeItemFromCart(id);
        return "removed" + getProductById(id).getName() + "from your cart!";
    }
}
