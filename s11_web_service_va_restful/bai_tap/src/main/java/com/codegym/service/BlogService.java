package com.codegym.service;

import com.codegym.model.Blog;
import com.codegym.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    IBlogRepository blogRepository;

    @Override
    public Iterable<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Page<Blog> findAllByAuthorContaining(String keyword, Pageable pageable){
        return blogRepository.findAllByAuthorContaining(keyword,pageable);
    }

    @Override
    public Page<Blog> searchByAuthorAndType(String author, Long categoryId, Pageable pageable) {
        return blogRepository.searchByAuthorAndType("%"+author+"%",categoryId,pageable);
    }

    @Override
    public Iterable<Blog> findAllByCategory(Long categoryId) {
        return blogRepository.findAllByCategory(categoryId);
    }

    @Override
    public Iterable<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll();
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public Blog save(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public void remove(Long id) {
        blogRepository.deleteById(id);
    }
}
