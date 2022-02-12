package com.sda.javaee9springdemo.contoller.rest;


import com.sda.javaee9springdemo.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/rest")
public class MyFirstRestController {

    //Person object is returned as JSON inside body of response
    @GetMapping("/one-person")
    public Person onePerson(){
        return new Person("Andreas","Meisner",34);
    }
}
