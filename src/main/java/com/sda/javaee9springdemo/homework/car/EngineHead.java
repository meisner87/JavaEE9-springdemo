package com.sda.javaee9springdemo.homework.car;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EngineHead {

    public EngineHead() {
        log.info("Engine head was created");
    }
}
