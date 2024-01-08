package com.app.springcoolapp.entity;


import lombok.*;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Person {
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
}
