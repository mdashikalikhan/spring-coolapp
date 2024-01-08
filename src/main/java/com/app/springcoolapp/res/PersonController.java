package com.app.springcoolapp.res;


import com.app.springcoolapp.entity.Person;
import com.app.springcoolapp.res.exception.PersonNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonController {

    private List<Person> personList;

    @PostConstruct
    private void loadPersons(){
        personList = new ArrayList<>();
        personList.add(new Person("Md. Ashik", "ALi Khan"));
        personList.add(new Person("Mohammad", "Ibrahim"));
        personList.add(new Person("Md. Hasnain ", "Khan"));
    }

    @GetMapping("/persons")
    public List<Person> getPersonList(){

        return personList;
    }

    @GetMapping("/persons/{id}")
    public Person getPerson(@PathVariable int id){

        if(id<0 || id >=personList.size()){
            throw new PersonNotFoundException("Person not found for id: " + id);
        }
        return personList.get(id);
    }


}
