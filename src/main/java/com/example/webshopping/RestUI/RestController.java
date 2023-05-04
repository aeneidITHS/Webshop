package com.example.webshopping.RestUI;


import com.example.webshopping.bussiness.Product;
import com.example.webshopping.bussiness.WebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    WebsiteService websiteService;

    @GetMapping("rest/product/all")
    public List<Product> getAllProducts(){
        return websiteService.getAllProducts();
    }
    @GetMapping("rest/product/id/{id}")
    public Product getProductById(@PathVariable Integer id){
        return websiteService.getProductById(id);
    }
    @GetMapping("rest/product/category/{category}")
    public List<Product> getProductByCategory(@PathVariable String category){
        return websiteService.findProductByCategory(category);
    }
    @DeleteMapping("rest/delete/product/{id}")
    public List<Product> deleteProductById(@PathVariable Integer id){
        return websiteService.deleteProductById(id);
    }
    @PostMapping("rest/add/product/{name}/{price}/{category}")
    public Product addProduct(@PathVariable String name,@PathVariable Double price, @PathVariable String category){
        return websiteService.addProductToDB(name,category,price);
    }
    @PutMapping("rest/add/product/{id}/{price}")
    public Product changePrice(@PathVariable Integer id,@PathVariable Double price){
        return websiteService.updateProductPrice(id,price);
    }

}
