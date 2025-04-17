package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello") // integrate all http methods
public class HelloController {
    @RequestMapping(value = {"", "/", "/home"})
    public String sayHello() {
        return "Hello !";
    }

//    @RequestMapping(value = {"/query"} ,method = RequestMethod.GET)
//    public String sayHello(@RequestParam(required = false, defaultValue = "Guest") String name) {
//        return "Hello "+name+ "!";
//    }

    @GetMapping("/{name}")
    public String sayHello(@PathVariable String name) {
        return "Hello "+name+ "!";
    }

    @PostMapping("/post")
    public String sayHello(@RequestBody User user) {
        return "Hello "+ user.getFirstName() + "!";
    }

    @PutMapping("/put/{firstName}")
    public String sayHello(@PathVariable String firstName,
                           @RequestParam(value = "lastname")String lastname) {
        return "Hello "+ firstName + " " + lastname + "!";
    }
}