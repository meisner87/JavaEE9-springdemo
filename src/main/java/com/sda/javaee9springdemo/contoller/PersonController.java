package com.sda.javaee9springdemo.contoller;


import com.sda.javaee9springdemo.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/person")
public class PersonController {

    public static final String PERSONS_KEY = "personsKey";

    @GetMapping("/names")
    public String showListOfPersonsNames(Model data){
    var persons
            = List.of(
            new Person("Andreas","Meisner",34),
            new Person("Jana","Pulk",36),
            new Person("Anton ","Losman",35)
    );

    data.addAttribute(PERSONS_KEY,persons);
        return "persons/persons-names";
    }
}
