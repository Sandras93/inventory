package com.Bander.inventory.product;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Builder

public class ProductDto {
        private Integer id;
        @NotBlank(message = "Product name is required")
        private String productName;
        private String description;
        private int price;
        private int quantity;
        @NotBlank(message = "Manufacturer name is required")
        private String manufacturer;
        private ProductType productType;
        private LocalDateTime createdTime;
        private LocalDateTime updatedTime;
        @Column(columnDefinition = "boolean default true")
        private boolean available;

        public static ProductDto fromEntity(ProductEntity product) {
                return ProductDto.builder()
                        .id(product.getId())
                        .productName(product.getProductName())
                        .description(product.getDescription())
                        .price(product.getPrice())
                        .quantity(product.getQuantity())
                        .manufacturer(product.getManufacturer())
                        .productType(product.getProductType())
                        .createdTime(product.getCreatedTime())
                        .updatedTime(product.getUpdatedTime())
                        .available(product.isAvailable())
                        .build();
        }
}
