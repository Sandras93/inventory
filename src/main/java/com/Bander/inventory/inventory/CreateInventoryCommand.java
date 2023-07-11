package com.Bander.inventory.inventory;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateInventoryCommand {
    @NotEmpty(message = "Can't be blank")
    private String inventoryName;
    @NotEmpty(message = "Can't be blank")
    private String address;
    private Integer customerId;
}
