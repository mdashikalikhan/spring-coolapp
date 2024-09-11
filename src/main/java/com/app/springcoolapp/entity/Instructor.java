package com.app.springcoolapp.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "instructor")
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "first_name")
    @NonNull private String firstName;

    @Column(name = "last_name")
    @NonNull private String lastName;

    @Column(name = "email")
    @NonNull private String email;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinColumn(name = "instructor_detail_id")
    private InstructorDetail instructorDetail;

    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
                CascadeType.REFRESH}, mappedBy = "instructor")
    private List<Course> courses;

    public Instructor() {
    }

    public void addCourse(Course course){
        if(courses==null){
            courses = new ArrayList<>();
        }
        courses.add(course);
    }

    public List<Course> getCourses(){
        if(courses==null){
            courses = new ArrayList<>();
        }
        return courses;
    }


}
