package com.my.demo.domain;

public class Product {
    private Long id;
    private final String name;
    private final Double price;
    private final java.time.LocalDateTime created;

  
    public Product(Long id, String name, Double price, java.time.LocalDateTime created) {
        if (price == null || price <= 0) {
            throw new IllegalArgumentException("Product price must be greater than 0");
        }
        this.id = id;
        this.name = name;
        this.price = price;
        this.created = created;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public Double getPrice() { return price; }

    public java.time.LocalDateTime getCreated() { return created; }
}
