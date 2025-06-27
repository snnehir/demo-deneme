package com.my.demo.demodenemeapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
    "com.my.demo.demodenemeapp",
    "com.my.demo.adapter",
    "com.my.demo.application"
})
public class DemoDenemeAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoDenemeAppApplication.class, args);
    }
}
