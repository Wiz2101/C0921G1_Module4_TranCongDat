package com.codegym.service;

import com.codegym.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService extends IGeneralService<Employee> {
    Page<Employee> findAll(Pageable pageable);
    Page<Employee> findByName(String keyword, Pageable pageable);
    Employee findByUsers_User (String username);
    Page<Employee> searchByNameAndSelect(String keyword, String position, String educationDegree, String division, Pageable pageable);
}
