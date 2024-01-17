package com.app.springcoolapp.model;



import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@Getter @Setter @ToString
public class StudentForm {

    @NotNull(message = "First Name can't be null")
    @NotEmpty(message = "Can't be empty")
    @Size(min = 2,message = "At least two characters are required.")
    //@Pattern(regexp = "^[A-Z]+(A-Z|a-z)*+[\\\\s.]*",message = "Name is not correct.")
    private String firstName;

    @NotNull(message = "Last Name can't be null")
    @NotEmpty(message = "Can't be empty")
    private String lastName;

    @NotNull(message = "District can't be null")
    @NotEmpty(message = "Can't be empty")
    private String district;

    @NotNull(message = "Favourite Language can't be null")
    @NotEmpty(message = "Can't be empty")
    private String favouriteLanguage;

    @NotNull(message = "Operating System can't be empty")
    @Size(min = 1,message = "At least one operating system must be selected")
    private List<String> favouriteSystems;

    private List<String> districts;

    private List<String> languages;

    private List<String> operatingSystems;
}
