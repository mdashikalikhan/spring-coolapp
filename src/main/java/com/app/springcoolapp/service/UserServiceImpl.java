package com.app.springcoolapp.service;

import com.app.springcoolapp.dao.UserDao;
import com.app.springcoolapp.dao.UserRoleDao;
import com.app.springcoolapp.entity.CustomUser;
import com.app.springcoolapp.entity.UserRoleMapping;
import com.app.springcoolapp.model.RegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    UserDao userDao;
    UserRoleDao userRoleDao;

    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserDao userDao, UserRoleDao userRoleDao, BCryptPasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.userRoleDao = userRoleDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public CustomUser findByUserName(String name) {
        return userDao.findByUserName(name);
    }

    @Override
    public void save(RegistrationForm form) {
        CustomUser customUser = new CustomUser();

        // assign customUser details to the customUser object
        customUser.setUserName(form.getUserName());
        customUser.setPassword(passwordEncoder.encode(form.getPassword()));
        customUser.setFirstName(form.getFirstName());
        customUser.setLastName(form.getLastName());
        customUser.setEmail(form.getEmail());
        customUser.setActive(1);

        // give customUser default role of "employee"

        // save customUser in the database
        userDao.save(customUser);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CustomUser user = userDao.findByUserName(username);


        if(user==null){
            throw new UsernameNotFoundException("Invalid username or password");
        }

        List<UserRoleMapping> userRoles = userRoleDao.getRolesbyUserId(user.getId());

        if(userRoles==null){
            throw new org.springframework.security.core.userdetails.UsernameNotFoundException("Roles are not defined");
        }
        List<String> roles = new ArrayList<>();
        userRoles.stream().forEach(r->roles.add(r.getRoleId()));

        Collection<? extends GrantedAuthority> authorities = mapRoleToAuthorities(roles);
        //authorities.stream().forEach(c-> System.out.println(c.toString()));
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword()
                , authorities);
    }

    private Collection<? extends GrantedAuthority> mapRoleToAuthorities(List<String> roles){
        return roles.stream().map(role->new SimpleGrantedAuthority(role)).collect(Collectors.toList());
    }
}
