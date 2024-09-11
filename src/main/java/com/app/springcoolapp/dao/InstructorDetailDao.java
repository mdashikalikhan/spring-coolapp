package com.app.springcoolapp.dao;

import com.app.springcoolapp.entity.InstructorDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorDetailDao extends JpaRepository<InstructorDetail, Long> {
}
