package com.my.demo.adapter.in.rest.product;

import org.assertj.core.api.Assertions;
import java.util.List;

public class ProductControllerAssertions {
    public static void assertProductResponse(List<ProductResponseDTO> response, int expectedSize, String expectedName) {
        Assertions.assertThat(response).hasSize(expectedSize);
        Assertions.assertThat(response.get(0).getName()).isEqualTo(expectedName);
    }
}
