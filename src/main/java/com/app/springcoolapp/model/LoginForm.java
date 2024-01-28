package com.app.springcoolapp.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@NoArgsConstructor
@Getter @Setter @ToString
public class LoginForm {
    @NotNull(message = "User Name can't be null")
    @NotEmpty(message = "User Name can't be empty")
    @Size(min = 11, message = "User Name minimum length 11")
    private String userName;
    @NotNull(message = "Password can't be null")
    @NotEmpty(message = "Password can't be empty")
    @Size(min = 8, message = "Password minimum length is 8")
    private String password;
}
