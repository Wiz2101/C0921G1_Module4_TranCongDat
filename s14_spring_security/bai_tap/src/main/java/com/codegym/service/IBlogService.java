package com.codegym.service;

import com.codegym.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    Blog findById(Long id);

    List<Blog> findByCategory(String category);

    List<Blog> findByName(String name);
}
