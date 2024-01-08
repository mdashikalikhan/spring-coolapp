package com.app.springcoolapp.dao;

import com.app.springcoolapp.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    public List<Employee> findAll();

    public Employee findById(int id);

    public Employee save(Employee theEmployee);

    public void deleteById(int id);
}
