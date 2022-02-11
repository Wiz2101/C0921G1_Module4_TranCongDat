package com.codegym.service;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService extends IGeneralService<Blog> {
    public Iterable<Blog> findAll();
    public Page<Blog> findAllByAuthorContaining(String keyword, Pageable pageable);
    public Page<Blog> searchByAuthorAndType(String author, Long categoryId, Pageable pageable);
    public Iterable<Blog> findAllByCategory(Long category);
}
