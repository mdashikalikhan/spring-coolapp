package com.app.springcoolapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "course")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "course_name")
    @NonNull
    private String courseName;

}
