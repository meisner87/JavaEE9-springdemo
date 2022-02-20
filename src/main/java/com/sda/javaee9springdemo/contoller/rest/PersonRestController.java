package com.sda.javaee9springdemo.contoller.rest;

import com.sda.javaee9springdemo.entity.PersonEntity;
import com.sda.javaee9springdemo.service.RealPersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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
    public List<PersonEntity> findAllPersons() {
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
        return personEntity.map(personEntity1 -> ResponseEntity.ok(personEntity1)) // Optional<PersonEntity> -> Optional<ResponseEntity<PersonEntity>>
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // /persons/1 - using DELETE HTTP VERB
// /persons/1 - using DELETE HTTP VERB
    @DeleteMapping("/persons/{id}")
    public ResponseEntity<Void> deletePersonEntityById(@PathVariable("id") Long id) {
        log.info("trying to delete person entity by id: [{}]", id);

        boolean deleted = realPersonService.deletePersonEntityById(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/persons")
    public ResponseEntity<PersonEntity> createPersonEntity(@RequestBody PersonEntity newPersonToSave) {
        log.info("received new person to save: [{}]", newPersonToSave);
        realPersonService.savePerson(newPersonToSave);


        return ResponseEntity.created(URI.create("/api/persons/%d".formatted(newPersonToSave.getId())))
                .body(newPersonToSave);
    }
}