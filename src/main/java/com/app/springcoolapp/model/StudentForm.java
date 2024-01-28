package com.app.springcoolapp.model;



import com.app.springcoolapp.validator.StudentCode;
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
    @Pattern(regexp = "^[A-Z][A-Za-z\\. ]*[A-Za-z]$",message = "First Name is not valid.")
    private String firstName;

    @NotNull(message = "Last Name can't be null")
    @NotEmpty(message = "Can't be empty")
    @Size(min = 2,message = "At least two characters are required.")
    private String lastName;

    @NotNull(message = "District can't be null")
    @NotEmpty(message = "Can't be empty")
    private String district;

    @NotNull(message = "Student Code can't be empty")
    @NotEmpty(message = "Can't be empty")
    @StudentCode(value = "STL-", message = "Must be start with STL-")
    private String studentCode;

    @NotNull(message = "Favourite Language can't be null")
    @NotEmpty(message = "Can't be empty")
    private String favouriteLanguage;

    @NotNull(message = "Operating System can't be empty")
    @Size(min = 1,message = "At least one operating system must be selected")
    private List<String> favouriteSystems;

    @Min(value = 1,message = "levels must be greater or equal to one")
    @Max(value = 12,message = "levels must be less or equal to twelve")
    @NotNull(message = "Levels is required")
    private Integer levels;

    private List<String> districts;

    private List<String> languages;

    private List<String> operatingSystems;
}
