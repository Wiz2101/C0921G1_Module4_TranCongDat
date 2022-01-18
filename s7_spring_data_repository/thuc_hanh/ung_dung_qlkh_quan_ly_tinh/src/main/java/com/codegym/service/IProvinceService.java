package com.codegym.service;

import com.codegym.model.Province;

import java.util.Optional;

public interface IProvinceService {
    public Iterable<Province> findAll();

    public Optional<Province> findById(Long id);

    public void save(Province province);

    public void remove(Long id);
}
