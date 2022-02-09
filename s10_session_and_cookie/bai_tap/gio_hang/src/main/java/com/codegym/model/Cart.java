package com.codegym.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    Map<Product,Integer> products = new HashMap<>();

    public Cart() {
    }

    public Cart(Map<Product, Integer> products) {
        this.products = products;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    public void addToCart(Product product){
        Integer currentQuantity = products.get(product);
        if (products.containsKey(product)){
            products.put(product,currentQuantity + 1);
        } else {
            products.put(product,1);
        }
    }

    public void decreaseFromCart(Product product){
        Integer currentQuantity = products.get(product);
        if (products.containsKey(product)){
            products.replace(product,currentQuantity - 1);
        }
    }

    public Long totalPayment(){
        long totalPayment = 0;
        for (Map.Entry<Product,Integer> entry:products.entrySet()){
            totalPayment += entry.getKey().getPrice() * 1000 * entry.getValue();
        }
        return totalPayment;
    }

    public void removeFromCart(Product product){
        products.remove(product);
    }
}
