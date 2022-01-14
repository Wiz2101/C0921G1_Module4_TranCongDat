package com.codegym.service;

import com.codegym.model.Person;
import com.codegym.repository.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPersonService {

    @Autowired
    IPersonRepository personRepository;
    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public void createPerson(com.codegym.model.Person person) {
        personRepository.createPerson(person);
    }
}
