package com.Bander.inventory.inventory;

import com.Bander.inventory.customer.CustomerEntity;
import com.Bander.inventory.product.ProductEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class CreateInventoryCommand {
    @NotEmpty(message = "Can't be blank")
    private String inventoryName;
    @NotEmpty(message = "Can't be blank")
    private String address;
    private int capacity;
    private int currentStock;
    private String description;
    private String email;
    private String phoneNum;
    private InventoryType inventoryType;
    private boolean open;
    private Integer customerId;
}
