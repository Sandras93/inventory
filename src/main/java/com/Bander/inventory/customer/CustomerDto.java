package com.Bander.inventory.customer;

import com.Bander.inventory.inventory.InventoryDto;
import com.Bander.inventory.inventory.InventoryEntity;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class CustomerDto {
    private Integer id;
    private String customerName;
    private String address;
    private String email;
    private String phoneNum;
    private LocalDateTime dateOfBirth;
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
