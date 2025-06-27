package com.my.demo.adapter.in.rest.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.my.demo.application.port.in.product.FindProductUseCase;
import com.my.demo.domain.Product;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductController {
    private final FindProductUseCase findProductUseCase;

    @Autowired
    public ProductController(FindProductUseCase findProductUseCase) {
        this.findProductUseCase = findProductUseCase;
    }

    @GetMapping("/products")
    public List<ProductResponseDTO> findProductByName(@RequestParam String name) {
        List<Product> products = findProductUseCase.findByName(name);
        return products.stream()
                .map(p -> new ProductResponseDTO(p.getId(), p.getName(), p.getPrice()))
                .collect(Collectors.toList());
    }
}
