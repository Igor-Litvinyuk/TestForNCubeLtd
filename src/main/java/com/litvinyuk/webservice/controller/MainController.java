package com.litvinyuk.webservice.controller;

import com.litvinyuk.webservice.model.Person;
import com.litvinyuk.webservice.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/")
    public String greeting() {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model){
        Iterable<Person> contacts = personRepository.findAll();
        model.put("contacts", contacts);
        return "main";
    }

    @PostMapping("/main")
    public String addContact(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String dateOfBirth,
                             @RequestParam String postalCode, @RequestParam String picture, Map<String, Object> model){
        Person person = new Person(firstName, lastName, dateOfBirth, postalCode, picture);
        personRepository.save(person);
        Iterable<Person> contacts = personRepository.findAll();
        model.put("contacts", contacts);
        return "main";
    }
}