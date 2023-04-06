package com.example.webshopping.ui;

import com.example.webshopping.bussiness.WebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebshopController {
    @Autowired
    WebsiteService websiteService;
    @PostMapping("/login")
    public String login(@RequestParam String user, @RequestParam String password, Model model){
        model.addAttribute(websiteService.Login(user,password));
        model.addAttribute(websiteService.getAllProducts());
        return "login";
    }
}
