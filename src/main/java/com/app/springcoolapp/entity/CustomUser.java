package com.app.springcoolapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="customuser")
@RequiredArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class CustomUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @NonNull
    @Column(name="name")
    private String userName;
    @Column(name="password")
    private String password;
    @Column(name="active")
    private int active;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;
}
