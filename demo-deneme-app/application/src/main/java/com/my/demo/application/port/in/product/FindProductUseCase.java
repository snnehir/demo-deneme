package com.my.demo.application.port.in.product;

import java.util.List;

import com.my.demo.domain.Product;

public interface FindProductUseCase {
    List<Product> findByName(String name);
}
