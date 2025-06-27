package com.my.demo.application.service.product;

import com.my.demo.application.port.in.product.FindProductUseCase;
import com.my.demo.application.port.out.persistance.ProductRepository;
import com.my.demo.domain.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FindProductService implements FindProductUseCase {
    private final ProductRepository productRepository;

    @Autowired
    public FindProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }
}
