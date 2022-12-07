package com.example.ShopKartApp_backend.dao;

import com.example.ShopKartApp_backend.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDao extends CrudRepository<User,Integer> {

    @Query(value = "SELECT `id`, `address`, `confirm_password`, `email`, `name`, `password`, `phone_no` FROM `users` WHERE `email`=:email AND `password`=:password",nativeQuery = true)
    List<User> verifycredentials(@Param("email") String email,@Param("password") String password );
}
