package com.app.springcoolapp.dao;

import com.app.springcoolapp.entity.CustomUser;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{
    private EntityManager entityManager;

    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public CustomUser findByUserName(String userName) {
        TypedQuery<CustomUser> query = entityManager.createQuery("from CustomUser" +
                " where userName=:name", CustomUser.class);
        query.setParameter("name", userName);
        CustomUser user = null;
        try{
            user = query.getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    @Override
    @Transactional
    public void save(CustomUser user) {
        entityManager.merge(user);
    }
}
