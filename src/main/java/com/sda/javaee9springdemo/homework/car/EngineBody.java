package com.sda.javaee9springdemo.homework.car;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EngineBody {
    public EngineBody() {
        log.info("Engine body was created");

    }
}
