package com.codegym.service.Impl;

import com.codegym.model.AttachService;
import com.codegym.repository.IAttachServiceRepository;
import com.codegym.service.IAttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AttachServiceService implements IAttachServiceService {
    @Autowired
    IAttachServiceRepository attachServiceRepository;

    @Override
    public List<AttachService> findAll() {
        return attachServiceRepository.findAll();
    }

    @Override
    public void save(AttachService attachService) {
        attachServiceRepository.save(attachService);
    }

    @Override
    public void remove(Long id) {
        attachServiceRepository.deleteById(id);
    }

    @Override
    public Optional<AttachService> findById(Long id) {
        return attachServiceRepository.findById(id);
    }
}
