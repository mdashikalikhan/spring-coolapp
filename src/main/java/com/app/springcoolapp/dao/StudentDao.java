package com.app.springcoolapp.dao;

import com.app.springcoolapp.entity.Student;

import java.util.List;

public interface StudentDao {
     Student save(Student theStudent);

     Student findById(Integer id);

     List<Student> findAll();

     List<Student> findByLastName(String lastName);

     void update(Student theStudent);

     void delete(int studentId);

     int deleteAll();

}
