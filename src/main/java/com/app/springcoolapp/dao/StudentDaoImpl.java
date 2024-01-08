package com.app.springcoolapp.dao;

import com.app.springcoolapp.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao{


    private EntityManager entityManager;

    @Autowired
    public StudentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public Student save(Student theStudent) {
        entityManager.persist(theStudent);
        return theStudent;
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager.createQuery("from Student",Student.class);
        List<Student> listStudent = query.getResultList();
        return listStudent;
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> query = entityManager.createQuery("from Student where lastName=:lname",
                Student.class);
        query.setParameter("lname", lastName);
        List<Student> listStudent = query.getResultList();

        return  listStudent;
    }

    @Transactional
    @Override
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(int studentId) {
        Student student = findById(studentId);
        if(student!=null){
            entityManager.remove(student);
        }
    }

    @Override
    @Transactional
    public int deleteAll() {
        int count = entityManager.createQuery("delete from Student").executeUpdate();
        return count;
    }
}
