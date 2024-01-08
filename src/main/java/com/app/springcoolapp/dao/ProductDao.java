package com.app.springcoolapp.dao;

import com.app.springcoolapp.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource (path = "products")
public interface ProductDao extends JpaRepository<Products, Long> {
}
