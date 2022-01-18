package com.codegym.service;

import com.codegym.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    void saveOrUpdate(Customer song);
    Customer findById(Long id);
    void edit (Customer song);
    void delete (Long id);
}
