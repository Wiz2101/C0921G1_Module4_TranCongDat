package com.codegym.service;

import com.codegym.model.Blog;

import java.util.List;

public interface IBlogService {
    public List<Blog> findAll();
    public void saveOrUpdate(Blog blog);
    public void delete(Long id);
    public Blog findById(Long id);
}
