package com.codegym.service;

import com.codegym.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService extends IGeneralService<Employee> {
    Page<Employee> findAll(Pageable pageable);
    Page<Employee> findByName(String keyword, Pageable pageable);
}