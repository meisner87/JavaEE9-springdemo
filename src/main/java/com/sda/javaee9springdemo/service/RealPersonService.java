package com.sda.javaee9springdemo.service;

import com.sda.javaee9springdemo.entity.PersonEntity;
import com.sda.javaee9springdemo.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RealPersonService {


    private final PersonRepository personRepository;


    public RealPersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<PersonEntity> readAllPersonEntities() {
        log.info("trying to read all persons entities");
        var result = personRepository.findAll();
        log.info("persons entities read from db ", result);
        return result;
    }
}
