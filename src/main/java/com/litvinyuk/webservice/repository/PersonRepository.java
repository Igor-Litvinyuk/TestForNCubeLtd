package com.litvinyuk.webservice.repository;

import com.litvinyuk.webservice.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
