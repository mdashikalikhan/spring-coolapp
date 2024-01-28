package com.app.springcoolapp.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @ToString
public class RegistrationForm {

    @NotNull(message = "user name is required")
    @Size(min = 8, message = "user name must not be less than 8 characters")
    private String userName;

    @NotNull(message = "Password is required")
    @Size(min = 8, message = "Password must not be less than 8 characters")
    private String password;

    @NotNull(message = "First name is required")
    @Size(min = 1, message = "is required")
    private String firstName;

    @NotNull(message = "Last name is required")
    @Size(min = 1, message = "is required")
    private String lastName;

    @NotNull(message = "Email is required")
    @Size(min = 1, message = "is required")
    @Pattern(regexp="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
    private String email;
}
