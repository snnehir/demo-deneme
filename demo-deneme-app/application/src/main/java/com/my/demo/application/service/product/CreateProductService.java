package com.my.demo.application.service.product;

import com.my.demo.application.port.in.product.CreateProductUseCase;
import com.my.demo.application.port.out.persistance.ProductRepository;
import com.my.demo.domain.Product;
import org.springframework.stereotype.Service;

@Service
public class CreateProductService implements CreateProductUseCase {
    private final ProductRepository productRepository;

    public CreateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
}
