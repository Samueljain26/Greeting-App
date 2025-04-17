package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.model.User;
import com.bridgelabz.greetingapp.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/greetings")
public class GreetingController {
    @Autowired
    private IGreetingService greetingService;

    @GetMapping(value = {"","/"})
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "world") String name,
                             @RequestParam(value = "last", defaultValue = "") String last) {
        User user = new User();
        user.setFirstName(name);
        user.setLastName(last);

        return greetingService.addGreeting(user);
    }

    @GetMapping("/{id}")
    public Greeting getById(@PathVariable long id){
        return greetingService.getGreetingById(id);
    }
    @GetMapping("/allUsers")
    public List<Greeting> getAllGreetings() {
        return greetingService.getAllGreetings();
    }

    @PutMapping("/edit/{id}")
    public Greeting editGreeting(@PathVariable Long id,
                                 @RequestParam(value = "name", defaultValue = "") String name,
                                 @RequestParam(value = "last", defaultValue = "") String last) {
        User user = new User();
        user.setFirstName(name);
        user.setLastName(last);
        return greetingService.updateGreeting(id, user);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteGreeting(@PathVariable Long id){
        return greetingService.deleteGreeting(id);
    }

}