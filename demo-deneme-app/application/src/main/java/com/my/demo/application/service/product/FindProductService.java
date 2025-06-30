package com.my.demo.application.service.product;

import com.my.demo.application.port.in.product.FindProductUseCase;
import com.my.demo.application.port.out.persistance.ProductRepository;
import com.my.demo.domain.Product;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FindProductService implements FindProductUseCase {
    private final ProductRepository productRepository;

    public FindProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * name null veya boş ise tüm ürünleri, dolu ise isme göre filtreli ürünleri döndürür.
     */
    @Override
    public List<Product> findProducts(String name) {
        if (name == null || name.isBlank()) {
            return productRepository.findAll();
        } else {
            return productRepository.findByName(name);
        }
    }
}
