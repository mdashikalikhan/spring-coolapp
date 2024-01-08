package com.app.springcoolapp.service;

import com.app.springcoolapp.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();

    public Employee findById(int id);

    public Employee save(Employee theEmployee);

    public void deleteById(int id);
}
