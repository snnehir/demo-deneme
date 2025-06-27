package com.my.demo.adapter.in.rest.product;

public class ProductResponseDTO {
    private Long id;
    private String ad;
    private Double price;

    public ProductResponseDTO(Long id, String ad, Double price) {
        this.id = id;
        this.ad = ad;
        this.price = price;
    }

    public Long getId() { return id; }
    public String getAd() { return ad; }
    public Double getPrice() { return price; }
}
