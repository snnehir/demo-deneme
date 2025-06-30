package com.my.demo.adapter.in.rest.product;

import com.my.demo.domain.Product;
import java.time.LocalDateTime;

public class ProductMapper {
    public static Product toDomain(CreateProductRequestDTO dto) {
        return new Product(null, dto.getName(), dto.getPrice(), LocalDateTime.now());
    }

    public static ProductResponseDTO toResponse(Product product) {
        return new ProductResponseDTO(product.getId(), product.getName(), product.getPrice());
    }
}
