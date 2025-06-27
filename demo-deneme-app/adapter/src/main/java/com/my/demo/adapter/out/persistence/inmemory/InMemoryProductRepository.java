package com.my.demo.adapter.out.persistence.inmemory;

import org.springframework.stereotype.Repository;

import com.my.demo.application.port.out.persistance.ProductRepository;
import com.my.demo.domain.Product;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class InMemoryProductRepository implements ProductRepository {
    private final ConcurrentHashMap<Long, Product> products = new ConcurrentHashMap<>();

    public InMemoryProductRepository() {
        products.put(1L, new Product(1L, "Elma", 10.0, LocalDateTime.now()));
        products.put(2L, new Product(2L, "Armut", 12.5, LocalDateTime.now()));
        products.put(3L, new Product(3L, "Muz", 15.0, LocalDateTime.now()));
        products.put(4L, new Product(4L, "Karpuz", 25.0, LocalDateTime.now()));
        products.put(5L, new Product(5L, "Çilek", 30.0, LocalDateTime.now()));
    }

    @Override
    public List<Product> findByName(String name) {
        return products.values().stream()
                .filter(p -> p.getName() != null && p.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }
}
