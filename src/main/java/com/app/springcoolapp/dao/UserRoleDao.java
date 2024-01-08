package com.app.springcoolapp.dao;

import com.app.springcoolapp.entity.UserRoleMapping;

import java.util.List;

public interface UserRoleDao {
    List<UserRoleMapping> getRolesbyUserId(Long id);
}
