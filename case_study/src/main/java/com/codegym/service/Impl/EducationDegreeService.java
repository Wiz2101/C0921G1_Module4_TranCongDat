package com.codegym.service.Impl;

import com.codegym.model.EducationDegree;
import com.codegym.repository.IEducationDegreeRepository;
import com.codegym.service.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EducationDegreeService implements IEducationDegreeService {
    @Autowired
    IEducationDegreeRepository educationDegreeRepository;
    @Override
    public List<EducationDegree> findAll() {
        return educationDegreeRepository.findAll();
    }

    @Override
    public void save(EducationDegree educationDegree) {
        educationDegreeRepository.save(educationDegree);
    }

    @Override
    public void remove(Long id) {
        educationDegreeRepository.deleteById(id);
    }

    @Override
    public Optional<EducationDegree> findById(Long id) {
        return educationDegreeRepository.findById(id);
    }
}
