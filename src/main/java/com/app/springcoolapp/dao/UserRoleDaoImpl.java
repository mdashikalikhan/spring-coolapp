package com.app.springcoolapp.dao;

import com.app.springcoolapp.entity.CustomUser;
import com.app.springcoolapp.entity.UserRoleMapping;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRoleDaoImpl implements UserRoleDao {
    private EntityManager entityManager;

    public UserRoleDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<UserRoleMapping> getRolesbyUserId(Long id) {
        TypedQuery<UserRoleMapping> query = entityManager.createQuery("from UserRoleMapping" +
                " where userId=:userId", UserRoleMapping.class);
        query.setParameter("userId", id);
        List<UserRoleMapping> queryResultList =null;

        try{
            queryResultList = query.getResultList();
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return queryResultList;
    }
}
