package com.Bander.inventory.customer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CustomerServiceTest {
    @Autowired
    CustomerService customerService;


//    CustomerDto customerDto2 = CustomerDto.builder()
//            .customerName("Bruh Csutomer")
//            .address("4422, Bruhville 1.")
//            .email("test@bruhmail.com")
//            .phoneNum("0630-7654-321")
//            .dateOfBirth(LocalDate.parse("1900-01-01"))
//            .customerGender(CustomerGender.FEMALE)
//            .active(true)
//            .build();


    @Test
    void createCustomerTest() {

        CustomerDto customerDto1 = CustomerDto.builder()
                .customerName("Test Customer")
                .address("1122, Mucsaröcsöge 1.")
                .email("test@example.com")
                .phoneNum("0630-123-4567")
                .dateOfBirth(LocalDate.parse("2000-01-01"))
                .customerGender(CustomerGender.MALE)
                .active(true)
                .build();

    CustomerDto savedCustomerDto = customerService.createCustomer(customerDto1);

    assertNotNull(savedCustomerDto.getId());
    assertEquals("Test Customer",savedCustomerDto.getCustomerName());
    assertEquals("1122, Mucsaröcsöge 1.",savedCustomerDto.getAddress());
    assertEquals(LocalDate.parse("2000-01-01"),savedCustomerDto.getDateOfBirth());

    }
}