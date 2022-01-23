package com.sda.javaee9springdemo.contoller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class FirstController {

    //the same as @Slf4j
    //private static final Logger log = LoggerFactory.getLogger(FirstController.class);


    @GetMapping({"/my-first-page", "/"})
    public String firstPage() {
        log.info("firstPage() method called!!!");
        // looking for html page inside resources/templates
        //Spring please use page:resources/templates/home-page.html
        return "home-page";
    }

    @GetMapping("/my-second-page")
    public String secondPage() {
        log.info("secondPage() method called!!!");
        return "my-second-page";
    }

    //@GetMapping("/pages/my-third-page")
    @GetMapping(value = {"my-third-page", "/my-third-too"})
    public String thirdPage() {
        log.info("thirdPage() method called!!!");
        return "pages/my-third-page";
    }

    @GetMapping("/my-name")
    public String myName(@RequestParam(value = "name", defaultValue = "Kalev") String myFirstName,
                         @RequestParam(value = "surname", defaultValue = "Tamm") String mySurname) {
        log.info("myName() method was called!!!");
        log.info("my name is: [{}] and my surname is: [{}]", myFirstName, mySurname);
        log.info(String.format("my name is: [%s] and my surname is: [%s]", myFirstName, mySurname));

        return "";
    }


}
