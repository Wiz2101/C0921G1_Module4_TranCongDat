package com.codegym.service.Impl;

import com.codegym.model.Customer;
import com.codegym.repository.ICustomerRepository;
import com.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Page<Customer> findByName(String keyword, Pageable pageable) {
        return customerRepository.findCustomerByCustomerNameContaining(keyword,pageable);
    }

    @Override
    public Page<Customer> findAllByDate(String date, Pageable pageable) {
        return customerRepository.findAllByDate(date, pageable);
    }

    @Override
    public Page<Customer> searchByNameAndSelect(String keyword, String customerType, Pageable pageable) {
        return customerRepository.searchByNameAndSelect(keyword, customerType, pageable);
    }
}
