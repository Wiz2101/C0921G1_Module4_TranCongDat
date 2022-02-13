package com.codegym.service;

import com.codegym.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
    public Page<Category> findAll(Pageable pageable);
    public void saveOrUpdate(Category blog);
    public void delete(Long id);
    public Category findById(Long id);
    public List<Category> findAll();
    public Page<Category> searchById(Long id, Pageable pageable);
}
