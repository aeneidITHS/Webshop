package com.example.webshopping.ui;

import com.example.webshopping.bussiness.Cart;
import com.example.webshopping.bussiness.WebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebshopController {
    @Autowired
    WebsiteService websiteService;

    @GetMapping("/register")
    public String goingToRegister(Model model){
        System.out.println("1");
        return "register";
    }
    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password,Model model){
        System.out.println("2");
        String userChecker = websiteService.checkIfUserExist(username,password);
        System.out.println("3");
        model.addAttribute("checkIfUserExist",userChecker);
        System.out.println("4");
        return "register";
    }
    @GetMapping("/login")
    public String login(Model model){
        return "login";
    }
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model){
        System.out.println("login1");
        model.addAttribute("login",websiteService.Login(username,password));
        System.out.println("login2");
        model.addAttribute("products",websiteService.getAllProducts());
        return "homePage";
    }
    @GetMapping("/adminLogin")
    public String adminLogin(Model model){
        return "adminLogin";
    }
    @PostMapping("/adminLogin")
    public String adminLogin(@RequestParam String username,@RequestParam String password, Model model){
        model.addAttribute("admin",websiteService.adminLogin(username,password));
        if(websiteService.isCurrentUserAdmin()){
            return "adminPage";
        }
        else {
            model.addAttribute("not admin",websiteService.adminLogin(username,password));
            return "adminLogin";
        }
    }
    @GetMapping("/homepage")
    public String showHomePage(Model m,@RequestParam long id){
        //Product p = websiteService.getProductById(id);
        //m.addAttribute("products",);
        return "homePage";
    }

    @PostMapping("/addCart")
    public String addCart(@RequestParam Long id, @RequestParam int amount, Model model){
        Cart cart = websiteService.addProductIntoCart(id,amount);
        model.addAttribute("cart",cart);
        return "productShop";
    }
    @GetMapping("/showCart")
    public String showCart(Model model){
        model.addAttribute("cart",websiteService.getCart());
        model.addAttribute("cartSum", websiteService.getCart().sumOfWholeCart());
        return "showCart";
    }
    @PostMapping("/removeFromCart")
    public String removeFromCart(@RequestParam int id, Model model){
        model.addAttribute("removedFromCart",websiteService.removeFromCart(id));
        model.addAttribute("cart",websiteService.getCart());
        model.addAttribute("cartSum",websiteService.getCart().sumOfWholeCart());
        return "showCart";
    }
    @PostMapping("/placeOrder")
    public String placeOrder(Model model){
        model.addAttribute("customerOrder",websiteService.addCustomerOrder());
        return "orders";
    }

    @PostMapping("/showSearchedItem")
    public String showSearchedItem(@RequestParam String searchWord,Model model){

        if (websiteService.findProductByName(searchWord) ==null){
            model.addAttribute("searchedItem","No product exists");
        }
        else {
            model.addAttribute("searcheditem",websiteService.findProductByName(searchWord));
        }
        return "searchPage";
    }
    @PostMapping("/showSearchedCategory")
    public String showSearchedCategory(@RequestParam String searchWord,Model model){

        if (websiteService.findProductByCategory(searchWord) ==null){
            model.addAttribute("searchedItem","No item exists in that category");
        }
        else {
            model.addAttribute("searchedItem",websiteService.findProductByCategory(searchWord));
        }
        return "searchPage";
    }
    @GetMapping("/addProduct")
    public String addProduct(Model model){
        return "addProduct";
    }
    @PostMapping("/addProduct")
    public String addProduct(@RequestParam String name, @RequestParam String category, @RequestParam double price, Model m){
        websiteService.addProductToDB(name,category,price);
        m.addAttribute("product", websiteService.findProductByName(name));
        return "addProduct";
    }
    @GetMapping("/orders")
    public String orders(Model model){
        model.addAttribute("customerOrders",websiteService.getAllCustomerOrders());
        model.addAttribute("customers",websiteService.getAllPeople());
        return "orders";
    }
    @PostMapping("/orders")
    public String orders(@RequestParam Integer shippingId, Model model){
        websiteService.getAllCustomerOrders().get(shippingId-1).setSent(true);
        websiteService.saveOrder(websiteService.getAllCustomerOrders().get(shippingId-1));
        model.addAttribute("customers",websiteService.getAllPeople());
        model.addAttribute("customerOrders",websiteService.getAllCustomerOrders());
        return "orders";
    }




}
