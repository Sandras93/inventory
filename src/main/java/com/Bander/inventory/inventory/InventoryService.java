package com.Bander.inventory.inventory;

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

}
