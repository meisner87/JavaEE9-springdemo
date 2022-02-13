package com.sda.javaee9springdemo.service;

import com.sda.javaee9springdemo.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RealPersonService {


private final PersonRepository personRepository;


    public RealPersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
}
