package com.codegym.service;

import com.codegym.model.Person;

import java.util.List;

public interface IPersonService {
    public List<Person> findAll();
    public void createPerson(com.codegym.model.Person person);
}
