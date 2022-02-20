package com.codegym.service;

import com.codegym.model.Customer;
import com.codegym.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService extends IGeneralService<Customer> {
    Page<Customer> findAll(Pageable pageable);
    Page<Customer> findByName(String keyword, Pageable pageable);
    Page<Customer> findAllByDate(String date, Pageable pageable);
}
