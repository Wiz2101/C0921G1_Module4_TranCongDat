package com.codegym.repository;

import com.codegym.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAll();
    void saveOrUpdate(Customer song);
    Customer findById(Long id);
    void edit (Customer song);
    void delete (Long id);
}
