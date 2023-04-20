package com.example.webshopping.bussiness;

import com.example.webshopping.data.OrderRepository;
import com.example.webshopping.data.UserRepository;
import com.example.webshopping.data.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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



    boolean adminRights = false;
    Person person;
    Admin admin;
    Product product;
    Cart cart;

    WebsiteService(){
        cart = new Cart();
        admin = new Admin();
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    public List<Person> getAllPeople(){
       return userRepository.findAll();
    }
    public Product getProductById(long id){
        return productRepository.findById(id).get();
    }
    public List<Product> findProductByCategory(String category){
        return productRepository.findProductsByCategory(category);
    }
    public List<Product> findProductByName(String name){
        return productRepository.findByName(name);
    }
    public List<Product> findProductByPrice(Double price){
        return productRepository.findByPrice(price);
    }
    public Person Login(String loginName, String password){
        List<Person> personList = userRepository.findByUserNameAndPassword(loginName,password);
        person = personList.get(0);
        return person;
    }
    public Set<String> getAllCategories(){
        Set<String> categories = new TreeSet<>();
        for (Product p:productRepository.findAll()){
            categories.add(p.getCategory());
        }
        return categories;
     }
    public String checkIfUserExist(String loginName, String password){
        List<Person> personList = userRepository.findByUserNameAndPassword(loginName,password);
        if (personList.isEmpty()){
            person = new Person(loginName,password);
            person = userRepository.save(person);
            return "Created new person!";
        }
        return "user exists";
    }
    public String adminLogin(String loginName,String password){
        if (loginName.equalsIgnoreCase(admin.getName())&&password.equalsIgnoreCase(admin.getPassword())){
            adminRights = true;
            return "Welcome!";
        }
        else {
            return "Incorrect username or password!";
        }
    }

    public Cart getCart() {
        return cart;
    }

    public void addProductToDB(String productName, String productCategory, Double productPrice){
        product = productRepository.save(new Product(productName,productPrice,productCategory));
    }

    public Cart addProductIntoCart(Long id, int amount){
        cart.cartItems.add(new CartItem(getProductById(id),amount));
        return cart;
    }
    public List<CustomerOrder> addCustomerOrder(){
        person.addOrder(new CustomerOrder(getCart().getCartItems(), person));
        person = userRepository.save(person);
        clearCart();
        return orderRepository.findCustomerOrderById(person.getId());
    }
    public void clearCart(){
        cart = new Cart();
    }
    public boolean isCurrentUserAdmin() {
        return adminRights;
    }
    public List<CustomerOrder> getAllCustomerOrders(){
        return orderRepository.findAll();
    }

    public void saveOrder(CustomerOrder customerOrder){
        customerOrder = orderRepository.save(customerOrder);
    }

    public String removeFromCart(int id){
        cart.removeItemFromCart(id);
        return "removed" + getProductById(id).getName() + "from your cart!";
    }
}
