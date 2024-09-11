package com.app.springcoolapp.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "youtube_channel")
    @NonNull
    private String youtubeChannel;

    @Column(name = "hobby")
    @NonNull
    private String hobby;

    @OneToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,
    CascadeType.PERSIST, CascadeType.REFRESH}, mappedBy = "instructorDetail")
    @ToString.Exclude
    private Instructor instructor;

    public InstructorDetail() {

    }
}
