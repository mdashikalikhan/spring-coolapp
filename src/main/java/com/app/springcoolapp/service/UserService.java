package com.app.springcoolapp.service;

import com.app.springcoolapp.entity.CustomUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    public CustomUser findByUserName(String name);
}
