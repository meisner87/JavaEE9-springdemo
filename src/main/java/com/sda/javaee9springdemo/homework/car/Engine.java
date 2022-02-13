package com.sda.javaee9springdemo.homework.car;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Engine {


    private EngineBody engineBody;
    private EngineHead engineHead;


    public Engine(EngineBody engineBody, EngineHead engineHead) {
        this.engineBody = engineBody;
        this.engineHead = engineHead;
        log.info("Engine was created");
    }
}
