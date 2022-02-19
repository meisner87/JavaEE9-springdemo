package com.sda.javaee9springdemo.contoller.rest;

import com.sda.javaee9springdemo.entity.PersonEntity;
import com.sda.javaee9springdemo.service.RealPersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/")
public class PersonRestController {

    private final RealPersonService realPersonService;

    @Autowired
    public PersonRestController(RealPersonService realPersonService) {
        this.realPersonService = realPersonService;
    }

    @GetMapping("/persons")
    public List<PersonEntity> findAllPersons(){
        log.info("findAllPersons() method was called");
        return realPersonService.readAllPersonEntities();
    }

    // /persons/1
    // /persons/10
    // /persons/12345
    @GetMapping("/persons/{id}")
    public ResponseEntity<PersonEntity> findPersonEntityById(@PathVariable("id") Long personId) {
        log.info("trying to find person entity by id: [{}]", personId);
        var personEntity = realPersonService.readPersonEntityById(personId);
        if (personEntity == null)
            return ResponseEntity.notFound().build();
//            return new ResponseEntity<>(null, null, HttpStatus.NOT_FOUND);;

        return ResponseEntity.ok(personEntity);
//        return new ResponseEntity<>(personEntity, null, HttpStatus.OK);
    }
}
