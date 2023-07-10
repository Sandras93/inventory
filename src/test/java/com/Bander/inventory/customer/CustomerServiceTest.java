package com.Bander.inventory.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerServiceTest {
    @Autowired
    private CustomerService customerService;

    CustomerDto customerDto1 = CustomerDto.builder()
            .customerName("Test Customer")
            .address("1122, Mucsaröcsöge 1.")
            .email("test@example.com")
            .phoneNum("0630-123-4567")
            .dateOfBirth(LocalDate.parse("2000-01-01"))
            .customerGender(CustomerGender.MALE)
            .active(true)
            .build();


    @Test
    void createCustomerTest() {
        CustomerDto savedCustomerDto = customerService.createCustomer(customerDto1);

        assertNotNull(savedCustomerDto.getId());
        assertEquals("Test Customer", savedCustomerDto.getCustomerName());
        assertEquals("1122, Mucsaröcsöge 1.", savedCustomerDto.getAddress());
        assertEquals(LocalDate.parse("2000-01-01"), savedCustomerDto.getDateOfBirth());

    }

    @Nested
    public class testWithExistingCustomers {

        CustomerDto testCustomer1;
        CustomerDto testCustomer2;

        @BeforeEach
        void setUp() {
            CustomerDto testCustomerDto1 = CustomerDto.builder()
                    .customerName("Bruh Customer")
                    .address("4422, Bruhville 1.")
                    .email("test@bruhmail.com")
                    .phoneNum("0630-7654-321")
                    .dateOfBirth(LocalDate.parse("1900-01-01"))
                    .customerGender(CustomerGender.FEMALE)
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

            testCustomer1 = customerService.createCustomer(testCustomerDto1);
            testCustomer2 = customerService.createCustomer(testCustomerDto2);
        }

        @AfterEach
        void tearDown() {
            customerService.deleteById(testCustomer1.getId());
            customerService.deleteById(testCustomer2.getId());
        }

        @Test
        void findByIdTest() {

            int testCustomer1Id = testCustomer1.getId();
            int testCustomer2Id = testCustomer2.getId();
            System.out.println("************** " +
                    "Customer1 id is: " + testCustomer1Id + " **************");
            System.out.println("************** " +
                    "Customer2 id is: " + testCustomer2Id + " **************");

            assertEquals(testCustomer1.getId(), customerService.findById(testCustomer1.getId()).getId());

        }

        @Test
        void findByNameTest() {
            System.out.println(testCustomer1.getCustomerName());

            assertEquals(testCustomer1.getCustomerName(),
                    customerService.findByCustomerName("Bruh Customer").getCustomerName());
        }

    }
}