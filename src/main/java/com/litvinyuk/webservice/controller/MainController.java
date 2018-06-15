package com.litvinyuk.webservice.controller;

import com.litvinyuk.webservice.domain.Person;
import com.litvinyuk.webservice.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MainController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/persons", method = RequestMethod.POST)
    @ResponseBody
    public Person savePerson(@RequestBody Person person) {
        return personService.save(person);
    }

    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    @ResponseBody
    public List<Person> getAllPersons() {
        return personService.getAll();
    }

    @RequestMapping(value = "/persons/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Optional<Person> getPerson(@PathVariable("id") long id) {
        return personService.getByID(id);
    }

    @RequestMapping(value = "/persons", method = RequestMethod.PATCH)
    @ResponseBody
    public Person updatePerson(@RequestBody Person person) {
        return personService.update(person);
    }

    @RequestMapping(value = "/persons/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable long id) {
        personService.remove(id);
    }
}