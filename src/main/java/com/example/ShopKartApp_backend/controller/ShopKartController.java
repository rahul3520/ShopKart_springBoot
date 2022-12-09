package com.example.ShopKartApp_backend.controller;

import com.example.ShopKartApp_backend.dao.ProductDao;
import com.example.ShopKartApp_backend.dao.UserDao;
import com.example.ShopKartApp_backend.model.Product;
import com.example.ShopKartApp_backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class ShopKartController {

    @Autowired
    private ProductDao pdao;

    @Autowired
    private UserDao udao;

    @CrossOrigin(origins = "*")
    @PostMapping(path ="/addproduct",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> AddProduct(@RequestBody Product p)
    {
        HashMap<String,String> map=new HashMap<>();

        System.out.println(p.toString());
        System.out.println(p.getId());
        System.out.println(p.getName().toString());
        System.out.println(p.getImage().toString());
        System.out.println(p.getCategory().toString());
        System.out.println(p.getDescription().toString());
        System.out.println(p.getPrice());

        pdao.save(p);

        map.put("status","success");

        return map;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path ="/adduser",produces = "application/json",consumes = "application/json")
    public HashMap<String,String> AddUser(@RequestBody User u)
    {
        HashMap<String,String> map=new HashMap<>();

        System.out.println(u.toString());
        System.out.println(u.getId());
        System.out.println(u.getName().toString());
        System.out.println(u.getAddress().toString());
        System.out.println(u.getPhoneNo().toString());
        System.out.println(u.getEmail().toString());
        System.out.println(u.getPassword().toString());
        System.out.println(u.getConfirmPassword().toString());

        udao.save(u);

        map.put("status","success");

        return map;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewproduct")
    public List<Product> ViewProduct()
    {
        return (List<Product>) pdao.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path ="/searchproduct",produces = "application/json",consumes ="application/json")
    public List<Product> SearchProduct(@RequestBody Product p)
    {
        String prodName=String.valueOf(p.getName());
        System.out.println(prodName);

        return (List<Product>) pdao.search(p.getName());
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path ="/searchuser",produces = "application/json",consumes = "application/json")
    public List<User> SearchUser(@RequestBody User u)
    {
        String emailid=String.valueOf(u.getEmail());
        String password=String.valueOf(u.getPassword());

        System.out.println(emailid + password);

        return (List<User>) udao.verifycredentials(u.getEmail(),u.getPassword());
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userloginverify",produces = "application/json",consumes = "application/json")
    public HashMap<String,String> UserCredentials(@RequestBody User u)
    {
        String email=String.valueOf(u.getEmail());
        String password=String.valueOf(u.getPassword());

        System.out.println(email);
        System.out.println((password));

        List<User> result= udao.SearchCred(u.getEmail(),u.getPassword());   //user details

        HashMap<String,String> map=new HashMap<>();



        if(result.size()==0)
        {
            map.put("status","Invalid");
            return map;
        }
        else
        {
            map.put("id",String.valueOf(result.get(0).getId()));    //resolved error in this line
            map.put("status","success");
            return map;
        }
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/viewUserLogged",produces = "application/json",consumes = "application/json")
    public List<User> ViewLoggedUser(@RequestBody User u)
    {
        String uid=String.valueOf(u.getId());

        System.out.println(uid);

        List<User> details=udao.ViewDetails(u.getId());

        return details;
    }


}
