package com.example.ShopKartApp_backend.controller;

import com.example.ShopKartApp_backend.dao.ProductDao;
import com.example.ShopKartApp_backend.dao.UserDao;
import com.example.ShopKartApp_backend.model.Product;
import com.example.ShopKartApp_backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopKartController {

    @Autowired
    private ProductDao pdao;

    @Autowired
    private UserDao udao;

    @CrossOrigin(origins = "*")
    @PostMapping(path ="/addproduct",consumes = "application/json",produces = "application/json")
    public String AddProduct(@RequestBody Product p)
    {
        System.out.println(p.toString());
        System.out.println(p.getId());
        System.out.println(p.getName().toString());
        System.out.println(p.getImage().toString());
        System.out.println(p.getCategory().toString());
        System.out.println(p.getDescription().toString());
        System.out.println(p.getPrice());

        pdao.save(p);

        return "product added to products table in shopkartDB";
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path ="/adduser",produces = "application/json",consumes = "application/json")
    public String AddUser(@RequestBody User u)
    {
        System.out.println(u.toString());
        System.out.println(u.getId());
        System.out.println(u.getName().toString());
        System.out.println(u.getAddress().toString());
        System.out.println(u.getPhoneNo().toString());
        System.out.println(u.getEmail().toString());
        System.out.println(u.getPassword().toString());
        System.out.println(u.getConfirmPassword().toString());

        udao.save(u);

        return "user added to users table in shopkartdb";
    }


}
