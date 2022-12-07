package com.example.ShopKartApp_backend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopKartController {

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addProduct",produces = "application/json",consumes = "application/json")
    public String AddProduct()
    {

        return "add product page";
    }
}
