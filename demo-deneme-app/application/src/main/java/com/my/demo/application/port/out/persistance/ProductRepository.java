package com.my.demo.application.port.out.persistance;

import java.util.List;

import com.my.demo.domain.Product;

public interface ProductRepository {
    List<Product> findByName(String name);
    List<Product> findAll();
    Product save(Product product);
}
