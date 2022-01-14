package com.codegym.service;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepository productRepository;

    @Override
    public List<Product> showAll() {
        return productRepository.showAll();
    }

    @Override
    public void create(Product product) {
        productRepository.create(product);
    }

    @Override
    public void update(Product product) {
        productRepository.update(product);
    }

    @Override
    public void delete(int id) {
        productRepository.delete(id);
    }

    @Override
    public Product viewDetail(int id) {
        return productRepository.viewDetail(id);
    }

    @Override
    public List<Product> search(String keyword) {
        return productRepository.search(keyword);
    }

    @Override
    public Product select(int id) {
        return productRepository.select(id);
    }
}
