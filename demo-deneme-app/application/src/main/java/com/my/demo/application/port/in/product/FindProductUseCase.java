package com.my.demo.application.port.in.product;

import java.util.List;

import com.my.demo.domain.Product;

public interface FindProductUseCase {
    /**
     * name null veya boş ise tüm ürünleri, dolu ise isme göre filtreli ürünleri döndürür.
     */
    List<Product> findProducts(String name);
}
