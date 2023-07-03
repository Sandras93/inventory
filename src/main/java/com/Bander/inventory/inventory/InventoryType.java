package com.Bander.inventory.inventory;

public enum InventoryType {
    WAREHOUSE("Warehouse"),
    GROCERY("Grocery shop");
    private final String inventoryType;

    InventoryType(String inventoryType) {
        this.inventoryType = inventoryType;
    }
    public  String getInventoryType(){
        return inventoryType;
    }
}
