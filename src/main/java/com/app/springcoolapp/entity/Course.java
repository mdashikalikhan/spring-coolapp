package com.app.springcoolapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "course")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    @NonNull
    private String title;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,
                CascadeType.REFRESH, CascadeType.PERSIST})
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    public String toString() {
        return "Course[id: " + id + ", " +  "title: " + title +"]";
    }

}
