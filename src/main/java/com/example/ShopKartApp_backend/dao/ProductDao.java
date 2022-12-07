package com.example.ShopKartApp_backend.dao;

import com.example.ShopKartApp_backend.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductDao extends CrudRepository<Product,Integer> {



}
