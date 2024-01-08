package com.app.springcoolapp.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PersonErrorReponse {

    private int code;
    private String message;

    private long timestamp;
}
