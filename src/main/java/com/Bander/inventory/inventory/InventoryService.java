package com.Bander.inventory.inventory;

import com.Bander.inventory.customer.CustomerEntity;
import com.Bander.inventory.customer.CustomerService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private CustomerService customerService;

    public InventoryDto createInventory(CreateInventoryCommand command) {
        CustomerEntity customer = customerService.findCustomerEntityById(command.getCustomerId());

        InventoryEntity newInventory = InventoryEntity.builder()
                .inventoryName(command.getInventoryName())
                .address(command.getAddress())
                .capacity(command.getCapacity())
                .currentStock(command.getCurrentStock())
                .description(command.getDescription())
                .email(command.getEmail())
                .phoneNum(command.getPhoneNum())
                .inventoryType(command.getInventoryType())
                .open(command.isOpen())
                .customer(customer)
                .build();
        return InventoryDto.factory(inventoryRepository.save(newInventory));
    }
}
