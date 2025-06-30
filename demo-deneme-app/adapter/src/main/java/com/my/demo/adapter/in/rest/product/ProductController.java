package com.my.demo.adapter.in.rest.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.my.demo.application.port.in.product.FindProductUseCase;
import com.my.demo.application.port.in.product.CreateProductUseCase;
import com.my.demo.domain.Product;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductController {
    private final FindProductUseCase findProductUseCase;
    private final CreateProductUseCase createProductUseCase;
    public ProductController(FindProductUseCase findProductUseCase, CreateProductUseCase createProductUseCase) {
        this.findProductUseCase = findProductUseCase;
        this.createProductUseCase = createProductUseCase;
    }

    @GetMapping("/products")
    public List<ProductResponseDTO> findProducts(@RequestParam(required = false) String name) {
        List<Product> products = findProductUseCase.findProducts(name);
        return products.stream()
                .map(ProductMapper::toResponse)
                .collect(Collectors.toList());
    }

    @PostMapping("/products")
    public ProductResponseDTO createProduct(@RequestBody CreateProductRequestDTO request) {
        Product product = ProductMapper.toDomain(request);
        Product created = createProductUseCase.createProduct(product);
        return ProductMapper.toResponse(created);
    }
}
