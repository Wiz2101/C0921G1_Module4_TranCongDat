package com.codegym.repository;

import com.codegym.model.Person;

import java.util.List;

public interface IPersonRepository {
    public List<Person> findAll();
    public void createPerson(com.codegym.model.Person person);
}
