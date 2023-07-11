package com.Bander.inventory.inventory;

import com.Bander.inventory.customer.CustomerDto;
import com.Bander.inventory.customer.CustomerGender;
import com.Bander.inventory.customer.CustomerService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InventoryServiceTest {
    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private CustomerService customerService;

    private CustomerDto testCustomer1;
    private CustomerDto testCustomer2;

    CustomerDto testCustomerDto1 = CustomerDto.builder()
            .customerName("Test Customer")
            .address("1122, Mucsaröcsöge 1.")
            .email("test@example.com")
            .phoneNum("0630-123-4567")
            .dateOfBirth(LocalDate.parse("2000-01-01"))
            .customerGender(CustomerGender.MALE)
            .active(true)
            .build();

    CustomerDto testCustomerDto2 = CustomerDto.builder()
            .customerName("Poggers Customer")
            .address("2244,PogVille 1.")
            .email("poggers@pogmail.com")
            .phoneNum("0630-456-1243")
            .dateOfBirth(LocalDate.parse("2000-01-01"))
            .customerGender(CustomerGender.OTHER)
            .active(true)
            .build();
    @BeforeEach
    void setUp() {
        testCustomer1 = customerService.createCustomer(testCustomerDto1);
        testCustomer2 = customerService.createCustomer(testCustomerDto2);
    }

    @AfterEach
    void tearDown() {
        customerService.deleteById(testCustomer1.getId());
        customerService.deleteById(testCustomer2.getId());
    }

    @Test
    void createInventoryTest() {
        CreateInventoryCommand inventory = CreateInventoryCommand.builder()
                .inventoryName("First inventory")
                .address("1122, Inventory address")
                .capacity(1000)
                .currentStock(500)
                .description("This is an inventory")
                .email("inventory@example.com")
                .phoneNum("0630-852-9637")
                .inventoryType(InventoryType.WAREHOUSE)
                .open(true)
                .customerId(testCustomer1.getId())
                .build();

        InventoryDto createdInventory = inventoryService.createInventory(inventory);

        assertNotNull(createdInventory.getId());
        assertEquals("First inventory",createdInventory.getInventoryName());
    }
}