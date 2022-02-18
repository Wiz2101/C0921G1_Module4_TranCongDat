package com.codegym.service;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<T> {
    List<T> findAll();
    void save(T t);
    void remove(Long id);
    Optional<T> findById(Long id);
}
