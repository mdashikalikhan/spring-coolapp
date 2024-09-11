package com.app.springcoolapp.dao;

import com.app.springcoolapp.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface InstructorDao extends JpaRepository<Instructor, Long> {
    @Query("select i from Instructor i left join fetch i.courses " +
            " where i.id=:data")
    Instructor findInstructorById(long data);
}
