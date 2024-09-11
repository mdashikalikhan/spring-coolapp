package com.app.springcoolapp.dao;

import com.app.springcoolapp.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDao extends JpaRepository<Course, Long> {
}
