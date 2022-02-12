package com.sda.javaee9springdemo.contoller.rest;


import com.sda.javaee9springdemo.entity.Child;
import com.sda.javaee9springdemo.entity.Mother;
import com.sda.javaee9springdemo.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/rest")
public class MyFirstRestController {

    //Person object is returned as JSON inside body of response
    @GetMapping("/one-person")
    public Person onePerson(){
        return new Person("Andreas","Meisner",34);
    }

    @GetMapping("/persons")
    public List<Person> persons(){
        return List.of(
                new Person("Jana","Pulk",35),
                new Person("Anton","Losman",37)
        );
    }

    @GetMapping("/persons-array")
    public Person[] personsArray(){
        return new Person[] {
                new Person("Jana","Pulk",35),
                new Person("Anton","Losman",37)

    };
}

@GetMapping("/mother")
    public Mother motherWithChild(){
        return new Mother("Anna",new Child("Maria","female"));
}
}
