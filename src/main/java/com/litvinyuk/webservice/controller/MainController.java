package com.litvinyuk.webservice.controller;

import com.litvinyuk.webservice.model.Person;
import com.litvinyuk.webservice.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Controller
public class MainController {
    @Autowired
    private PersonRepository personRepository;

    @Value("${upload.path}")
    private String uploadPath;

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
                             @RequestParam String postalCode, @RequestParam("file") MultipartFile file, Map<String, Object> model) throws IOException {
        Person person = new Person(firstName, lastName, dateOfBirth, postalCode);
        if (file == null){
            person.setFilename("NoImage");
        }
        else if (!file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFilename));

            person.setFilename(resultFilename);
        }
        personRepository.save(person);
        Iterable<Person> contacts = personRepository.findAll();
        model.put("contacts", contacts);
        return "main";
    }
}