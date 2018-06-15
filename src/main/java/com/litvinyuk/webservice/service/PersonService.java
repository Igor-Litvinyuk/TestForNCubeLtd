package com.litvinyuk.webservice.service;

import com.litvinyuk.webservice.domain.Person;
import com.litvinyuk.webservice.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService{

    @Autowired
    PersonRepository personRepository;

    public Person save(Person person) {
        return personRepository.save(person);
    }

    public List<Person> getAll() {
        return personRepository.findAll();
    }

    public Optional<Person> getByID(long id) {
        return personRepository.findById(id);
    }

    public Person update(Person person) {
        return personRepository.save(person);
    }

    public void remove(long id) {
        personRepository.deleteById(id);
    }
}

//    @Value("${upload.path}")
//    private String uploadPath;
//    @PostMapping("/main")
//    public String addContact(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String dateOfBirth,
//                             @RequestParam String postalCode, @RequestParam("file") MultipartFile file, Map<String, Object> model) throws IOException {
//        Person person = new Person(firstName, lastName, dateOfBirth, postalCode);
//        if (file == null){
//            person.setFilename("NoImage");
//        }
//        else if (!file.getOriginalFilename().isEmpty()) {
//            File uploadDir = new File(uploadPath);
//            if (!uploadDir.exists()) {
//                uploadDir.mkdir();
//            }
//
//            String uuidFile = UUID.randomUUID().toString();
//            String resultFilename = uuidFile + "." + file.getOriginalFilename();
//
//            file.transferTo(new File(uploadPath + "/" + resultFilename));
//
//            person.setFilename(resultFilename);
//        }
//        personRepository.save(person);
//        Iterable<Person> contacts = personRepository.findAll();
//        model.put("contacts", contacts);
//        return "main";
//    }
//
//    @PostMapping("/deletePerson")
//    public String deletePerson(@RequestParam Long idFilter, Map<String, Object> model){
//        Iterable<Person> contacts;
//        if(idFilter != null && !idFilter.toString().isEmpty() && personRepository.findById(idFilter).isPresent()){
//            personRepository.deleteById(idFilter);
//            contacts = personRepository.findAll();
//        }
//        else {
//            contacts = personRepository.findAll();
//        }
//        model.put("contacts", contacts);
//        return "redirect:/main";
//    }
//
//    @PostMapping("/updatePerson")
//    public String updatePerson(@RequestParam Long idFilter, @RequestParam String firstName,
//                               @RequestParam String lastName, @RequestParam String dateOfBirth,
//                               @RequestParam String postalCode, Map<String, Object> model){
//        Iterable<Person> contacts;
//        if(idFilter != null && !idFilter.toString().isEmpty() && personRepository.findById(idFilter).isPresent()){
//            contacts = personRepository.findAll();
//            for (Person somePerson : contacts){
//                if (somePerson.getId().equals(idFilter)){
//                    somePerson.setFirstName(firstName);
//                    somePerson.setLastName(lastName);
//                    somePerson.setDateOfBirth(dateOfBirth);
//                    somePerson.setPostalCode(postalCode);
//                    personRepository.save(somePerson);
//                }
//            }
//            contacts = personRepository.findAll();
//        }
//        else {
//            contacts = personRepository.findAll();
//        }
//        model.put("contacts", contacts);
//        return "redirect:/main";
//    }