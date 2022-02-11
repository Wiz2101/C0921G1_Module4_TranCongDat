package com.codegym.service;

import com.codegym.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService extends IGeneralService<Category>{
    Iterable<Category> findAll();
    public List<Category> findAll(Pageable pageable);
    public Page<Category> searchById(Long id, Pageable pageable);
}
