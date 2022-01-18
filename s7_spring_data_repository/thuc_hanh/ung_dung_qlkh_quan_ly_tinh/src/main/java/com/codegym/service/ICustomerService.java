package com.codegym.service;

import com.codegym.model.Customer;
import com.codegym.model.Province;

import java.util.Optional;

public interface ICustomerService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    void save(Customer customer);

    void remove(Long id);

    public Iterable<Customer> findAllByProvince(Province province);
}
