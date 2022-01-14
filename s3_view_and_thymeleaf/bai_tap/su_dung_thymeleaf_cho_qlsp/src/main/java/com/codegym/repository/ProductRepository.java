package com.codegym.repository;

import com.codegym.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "FL680", 9, 2350000L, "65%"));
        productList.add(new Product(2, "FL980", 4, 3350000L, "95%"));
        productList.add(new Product(3, "NJ68 Max", 5, 2650000L, "65%"));
        productList.add(new Product(4, "NJ80", 3, 3350000L, "75%"));
    }

    @Override
    public List<Product> showAll() {
        return productList;
    }

    @Override
    public void create(Product product) {
        productList.add(product);
    }

    @Override
    public void update(Product product) {
        for (Product li : productList) {
            if (li.getId() == product.getId()) {
                productList.set(product.getId() - 1, product);
            }
        }
    }

    @Override
    public void delete(int id) {
        Iterator<Product> iterator = productList.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getId() == id) {
                productList.remove(product);
                break;
            }
        }

    }

    @Override
    public Product viewDetail(int id) {
        for (Product li : productList) {
            if (li.getId() == id) {
                return li;
            }
        }
        return null;
    }

    @Override
    public List<Product> search(String keyword) {
        List<Product> searchList = new ArrayList<>();
        for (Product li : productList) {
            if (li.getName().toLowerCase().contains(keyword.toLowerCase())) {
                searchList.add(li);
            }
        }
        return searchList;
    }

    @Override
    public Product select(int id) {
        for (Product li : productList) {
            if (li.getId() == id) {
                return li;
            }
        }
        return null;
    }
}
