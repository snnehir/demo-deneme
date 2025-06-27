package com.my.demo.domain;

public class Product {
    private Long id;
    private String ad;
    private Double price;
    private java.time.LocalDateTime created;

    public Product() {}

    public Product(Long id, String ad, Double price, java.time.LocalDateTime created) {
        this.id = id;
        this.ad = ad;
        this.price = price;
        this.created = created;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAd() { return ad; }
    public void setAd(String ad) { this.ad = ad; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public java.time.LocalDateTime getCreated() { return created; }
    public void setCreated(java.time.LocalDateTime created) { this.created = created; }
}
