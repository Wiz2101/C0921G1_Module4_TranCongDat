package com.codegym.service.Impl;

import com.codegym.model.Contract;
import com.codegym.repository.IContractRepository;
import com.codegym.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ContractService implements IContractService {
    @Autowired
    IContractRepository contractRepository;
    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public void remove(Long id) {
        contractRepository.deleteById(id);
    }

    @Override
    public Optional<Contract> findById(Long id) {
        return contractRepository.findById(id);
    }

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }
}
