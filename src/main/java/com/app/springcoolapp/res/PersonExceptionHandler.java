package com.app.springcoolapp.res;

import com.app.springcoolapp.res.exception.PersonNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PersonExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<PersonErrorReponse> handleNotFoundException(PersonNotFoundException ex){
        PersonErrorReponse error = new PersonErrorReponse();
        error.setCode(HttpStatus.NOT_FOUND.value());
        error.setMessage(ex.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<PersonErrorReponse> handleException(Exception ex){
        PersonErrorReponse error = new PersonErrorReponse();
        error.setCode(HttpStatus.BAD_REQUEST.value());
        error.setMessage(ex.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
