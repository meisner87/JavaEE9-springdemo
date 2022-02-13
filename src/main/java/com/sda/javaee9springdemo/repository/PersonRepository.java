package com.sda.javaee9springdemo.repository;


import com.sda.javaee9springdemo.entity.PersonEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<PersonEntity,Long> {


}
