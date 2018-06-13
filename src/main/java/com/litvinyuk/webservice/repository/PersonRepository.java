package com.litvinyuk.webservice.repository;

import com.litvinyuk.webservice.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
