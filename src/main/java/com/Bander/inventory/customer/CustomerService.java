package com.Bander.inventory.customer;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    public CustomerDto findById(Integer id) {
        return CustomerDto.factory(customerRepository.getReferenceById(id));
    }

    public void deleteById(Integer id) {
        customerRepository.deleteById(id);
    }


    public CustomerDto findByCustomerName(String customerName) {
        return CustomerDto.factory(customerRepository.findCustomerByCustomerName(customerName));
    }

    public List<CustomerDto> findAllCustomers() {
        return customerRepository.findAll().stream()
                .map(CustomerDto::factory)
                .toList();
    }


    public CustomerDto editCustomer(CustomerDto dto) {
        var customerToEdit = customerRepository.getReferenceById(dto.getId());
        customerToEdit.setCustomerName(dto.getCustomerName());
        customerToEdit.setAddress(dto.getAddress());
        customerToEdit.setEmail(dto.getEmail());
        customerToEdit.setPhoneNum(dto.getPhoneNum());
        customerToEdit.setDateOfBirth(dto.getDateOfBirth());
        customerToEdit.setCustomerGender(dto.getCustomerGender());
        customerToEdit.setActive(dto.isActive());

        return CustomerDto.factory(customerToEdit);
    }

    public CustomerEntity findCustomerEntityById(Integer customerId) {
        return customerRepository.getReferenceById(customerId);
    }
}
