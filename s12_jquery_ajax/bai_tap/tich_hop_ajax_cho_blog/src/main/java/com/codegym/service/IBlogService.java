package com.codegym.service;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService {
    public Page<Blog> findAll(Pageable pageable);
    public void saveOrUpdate(Blog blog);
    public void delete(Long id);
    public Blog findById(Long id);
    public Page<Blog> findAllByAuthorContaining(String keyword, Pageable pageable);
    public Page<Blog> searchByAuthorAndType(String author, Long categoryId, Pageable pageable);
}
