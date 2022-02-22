package com.codegym.service.Impl;

import com.codegym.model.Employee;
import com.codegym.repository.IEmployeeRepository;
import com.codegym.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    IEmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void remove(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Page<Employee> findByName(String keyword, Pageable pageable) {
        return employeeRepository.findEmployeeByEmployeeNameContaining(keyword, pageable);
    }

    @Override
    public Employee findByUsers_User(String username) {
        return employeeRepository.findByUsers_User(username);
    }

    @Override
    public Page<Employee> searchByNameAndSelect(String keyword, String position, String educationDegree, String division, Pageable pageable) {
        return employeeRepository.searchByNameAndSelect(keyword, position, educationDegree, division, pageable);
    }
}
