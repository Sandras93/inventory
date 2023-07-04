package com.Bander.inventory.customer;

import com.Bander.inventory.inventory.InventoryDto;
import com.Bander.inventory.inventory.InventoryEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class CustomerDto {
    private Integer id;
    @NotBlank(message = "Customer name is required")
    private String customerName;
    private String address;
    private String email;
    @NotBlank(message = "Phone number is required")
    private String phoneNum;
    @NotBlank(message = "Date of birth is required")
    private LocalDate dateOfBirth;
    private CustomerGender customerGender;
    private boolean active;

    public static CustomerDto factory(CustomerEntity customer) {
        return CustomerDto.builder()
                .id(customer.getId())
                .customerName(customer.getCustomerName())
                .address(customer.getAddress())
                .email(customer.getEmail())
                .phoneNum(customer.getPhoneNum())
                .dateOfBirth(customer.getDateOfBirth())
                .customerGender(customer.getCustomerGender())
                .active(customer.isActive())
                .build();
    }
}
