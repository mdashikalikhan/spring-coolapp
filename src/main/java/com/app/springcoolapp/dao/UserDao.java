package com.app.springcoolapp.dao;


import com.app.springcoolapp.entity.CustomUser;

public interface UserDao {
    CustomUser findByUserName(String userName);
}
