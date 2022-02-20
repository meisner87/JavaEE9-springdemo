package com.sda.javaee9springdemo.repository;


import com.sda.javaee9springdemo.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
    //based on the name of that method spring is going to build sql query for us
    //Spring is using class properties to build the query: like name,surname or age
    //use it only for simple cases!!!(short method names)!!!
    //for complicated or long sql queries use "Query annotation
    boolean existsByNameAndSurname(String name, String surname);

    //we can provide our own query and spring with Hibernate are going to use it.
    //it is very useful for longer queries
    //we've got two options here:
    //using native sqls(with nativeQuery set to true) or JPQL (with nativeQueries set to false)
    //JPQL - Java persistence Query language - subset of SQL
    @Query(value = """
    SELECT COUNT (*) > 0
    FROM PERSON_ENTITIES
    WHERE name = :name AND surname = :surname
""", nativeQuery = true)
    boolean checkDuplicates(String name, String surname);
}
