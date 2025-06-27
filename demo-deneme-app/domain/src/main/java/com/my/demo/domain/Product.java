package com.my.demo.domain;

public class Product {
    private Long id;
    private String name;
    private Double price;
    private java.time.LocalDateTime created;

    public Product() {}

    public Product(Long id, String name, Double price, java.time.LocalDateTime created) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.created = created;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public java.time.LocalDateTime getCreated() { return created; }
    public void setCreated(java.time.LocalDateTime created) { this.created = created; }
}
