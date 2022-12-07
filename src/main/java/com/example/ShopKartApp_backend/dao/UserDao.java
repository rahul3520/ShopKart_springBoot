package com.example.ShopKartApp_backend.dao;

import com.example.ShopKartApp_backend.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User,Integer> {

}
