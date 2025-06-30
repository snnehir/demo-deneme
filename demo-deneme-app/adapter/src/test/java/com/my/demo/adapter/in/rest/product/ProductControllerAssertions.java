package com.my.demo.adapter.in.rest.product;

import org.assertj.core.api.Assertions;
import java.util.List;

public class ProductControllerAssertions {
    public static void assertProductResponse(List<ProductResponseDTO> response, int expectedSize, String expectedName) {
        Assertions.assertThat(response).hasSize(expectedSize);
        Assertions.assertThat(response.get(0).getName()).isEqualTo(expectedName);
    }

    public static void assertSingleProductResponse(ProductResponseDTO response, String expectedName, double expectedPrice) {
        Assertions.assertThat(response.getName()).isEqualTo(expectedName);
        Assertions.assertThat(response.getPrice()).isEqualTo(expectedPrice);
    }

    public static void assertProductListResponse(List<ProductResponseDTO> response, int expectedSize) {
        Assertions.assertThat(response).hasSize(expectedSize);
    }

    // 400 Bad Request ve hata mesajı için assertion
    public static void assertBadRequestWithMessage(int status, String responseBody, String expectedMessage) {
        Assertions.assertThat(status).isEqualTo(400);
        Assertions.assertThat(responseBody).contains(expectedMessage);
    }
}
