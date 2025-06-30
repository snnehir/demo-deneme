package com.my.demo.adapter.out.persistence.jpa;

import com.my.demo.application.port.out.persistance.ProductRepository;
import com.my.demo.domain.Product;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@ConditionalOnProperty(name = "persistence", havingValue = "postgresql")
@Repository
public class JpaProductRepository implements ProductRepository {
    private final JpaProductRepositorySpring springRepo;

    public JpaProductRepository(JpaProductRepositorySpring springRepo) {
        this.springRepo = springRepo;
    }

    @Override
    public List<Product> findByName(String name) {
        return springRepo.findByNameContainingIgnoreCase(name)
                .stream()
                .map(ProductEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Product save(Product product) {
        ProductEntity entity = ProductEntityMapper.toEntity(product);
        // id null ise yeni kayıt, değilse update
        ProductEntity saved = springRepo.save(entity);
        return ProductEntityMapper.toDomain(saved);
    }

    @Override
    public List<Product> findAll() {
        return springRepo.findAll().stream()
                .map(ProductEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

}
