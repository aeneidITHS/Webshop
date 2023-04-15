package com.example.webshopping.ui;

import com.example.webshopping.bussiness.Cart;
import com.example.webshopping.bussiness.Product;
import com.example.webshopping.bussiness.WebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebshopController {
    @Autowired
    WebsiteService websiteService;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model){
        model.addAttribute(websiteService.Login(username,password));
        model.addAttribute(websiteService.getAllProducts());
        return "homePage";
    }
    @PostMapping("/adminLogin")
    public String adminLogin(@RequestParam String user,@RequestParam String password, Model model){
        model.addAttribute("admin",websiteService.adminLogin(user,password));
        return "login";
    }
    @GetMapping("/register")
    public String goingToRegister(Model model){
        return "register";
    }
    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password,Model model){
        String userChecker = websiteService.checkIfUserExist(username,password);
        model.addAttribute("checkIfUserExist",userChecker);
        return "register";
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
        return "orderPlaced";
    }
    @GetMapping("/homepage")
    public String showHomePage(Model m,@RequestParam long id){
            Product p = websiteService.getProductById(id);
            m.addAttribute("product",p);
            return "homePage";
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
            model.addAttribute("searcheditem",websiteService.findProductByCategory(searchWord));
        }
        return "searchPage";
    }
    @PostMapping("/addProduct")
    public String addProduct(@RequestParam String name, @RequestParam String category, @RequestParam double price, Model m){
        websiteService.addProductToDB(name,category,price);
        m.addAttribute("product", new Product());
        return "addProduct";
    }





}
