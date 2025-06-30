package com.my.demo.application.port.in.product;

import com.my.demo.domain.Product;

public interface CreateProductUseCase {
    Product createProduct(Product product);
}
