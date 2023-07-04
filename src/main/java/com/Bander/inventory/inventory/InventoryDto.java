package com.Bander.inventory.inventory;

import com.Bander.inventory.product.ProductDto;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class InventoryDto {
    private Integer id;
    private String inventoryName;
    private int capacity;
    private int currentStock;
    private String address;
    private String description;
    private String email;
    private String phoneNum;
    private InventoryType inventoryType;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
    @Column(columnDefinition = "boolean default true")
    private boolean open;
    private List<ProductDto> productDtos = new ArrayList<>();

    public static InventoryDto factory (InventoryEntity inventory){
        return InventoryDto.builder()
                .id(inventory.getId())
                .inventoryName(inventory.getInventoryName())
                .capacity(inventory.getCapacity())
                .currentStock(inventory.getCurrentStock())
                .address(inventory.getAddress())
                .description(inventory.getDescription())
                .email(inventory.getEmail())
                .phoneNum(inventory.getPhoneNum())
                .inventoryType(inventory.getInventoryType())
                .createdTime(inventory.getCreatedTime())
                .updatedTime(inventory.getUpdatedTime())
                .open(inventory.isOpen())
                .build();
    }

}
