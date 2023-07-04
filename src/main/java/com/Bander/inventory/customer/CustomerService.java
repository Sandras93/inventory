package com.Bander.inventory.customer;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Transactional
@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;


    public CustomerDto createCustomer(CustomerDto customerDto) {
        CustomerEntity customer = CustomerEntity.builder()
                .customerName(customerDto.getCustomerName())
                .address(customerDto.getAddress())
                .email(customerDto.getEmail())
                .phoneNum(customerDto.getPhoneNum())
                .dateOfBirth(customerDto.getDateOfBirth()).
                customerGender(customerDto.getCustomerGender())
                .active(customerDto.isActive())
                .build();
        return CustomerDto.factory(customerRepository.save(customer));
    }
}
