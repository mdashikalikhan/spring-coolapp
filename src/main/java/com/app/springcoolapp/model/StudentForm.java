package com.app.springcoolapp.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter @Setter @ToString
public class StudentForm {

    private String firstName;

    private String lastName;

    private String district;
}
