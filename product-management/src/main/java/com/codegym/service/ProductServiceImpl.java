package com.codegym.service;

import com.codegym.model.Product;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private static Map<Integer, Product> products = new HashMap<>();

    static {
        products.put(1, new Product(1, "iPhone 15 Pro", 1000.0, "Apple flagship", "Apple"));
        products.put(2, new Product(2, "Galaxy S24", 900.0, "Samsung flagship", "Samsung"));
        products.put(3, new Product(3, "MacBook Air M2", 1200.0, "Thin and light laptop", "Apple"));
        products.put(4, new Product(4, "Dell XPS 15", 1500.0, "Premium laptop", "Dell"));
        products.put(5, new Product(5, "Sony WH-1000XM5", 350.0, "Noise cancelling headphones", "Sony"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> result = new ArrayList<>();
        for (Product p : products.values()) {
            if (p.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(p);
            }
        }
        return result;
    }
}
