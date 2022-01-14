package com.codegym.repository;

import com.codegym.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> showAll();
    void create(Product product);
    void update(Product product);
    void delete(int id);
    Product viewDetail(int id);
    List<Product> search(String keyword);
    Product select(int id);
}
