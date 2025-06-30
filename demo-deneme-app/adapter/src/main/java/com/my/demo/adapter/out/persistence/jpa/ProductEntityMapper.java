package com.my.demo.adapter.out.persistence.jpa;

import com.my.demo.domain.Product;

public class ProductEntityMapper {
    public static Product toDomain(ProductEntity entity) {
        if (entity == null) return null;
        return new Product(entity.getId(), entity.getName(), entity.getPrice(), entity.getCreated());
    }

    public static ProductEntity toEntity(Product product) {
        if (product == null) return null;
        return new ProductEntity(product.getId(), product.getName(), product.getPrice(), product.getCreated());
    }
}
