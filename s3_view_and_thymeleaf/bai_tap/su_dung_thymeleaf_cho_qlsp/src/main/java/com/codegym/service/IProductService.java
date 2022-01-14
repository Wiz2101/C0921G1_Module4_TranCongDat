package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> showAll();
    void create(Product product);
    void update(Product product);
    void delete(int id);
    Product viewDetail(int id);
    List<Product> search(String keyword);
    Product select(int id);

}
