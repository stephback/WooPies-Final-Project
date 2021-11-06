package com.woopiesfinalproject.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.woopiesfinalproject.entity.Customers;
import com.woopiesfinalproject.service.CustomerService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultCustomerController implements CustomerController {

    @Autowired
    private CustomerService customerService;
    
    // Get (read customers)
    @Override
    public List<Customers> fetchCustomers(Long customerPK, String customerId) {
      log.info("customerPK={}, customerId={}", customerPK, customerId); 
      
      return customerService.fetchCustomers(customerPK, customerId); 
    }
    
    // Post (create customers)
    @Override
    public Optional<Customers> createCustomers(String customerId, String firstName, 
        String lastName, String phone) {
      log.info("customerId={}, firstName={}, lastName={}, phone={}", customerId, firstName, 
          lastName, phone);
      
      return customerService.createCustomers(customerId, firstName, lastName, phone);
    }
    
    // Put (update customers)
    @Override
    public Optional<Customers> updateCustomers(String customerId, String firstName, String lastName, 
        String phone, String newFirstName, String newLastName, String newPhone) {
      log.info("customerId={}, firstName={}, lastName={}, phone={}, newFirstName={}, "
          + "newLastName={}, newPhone={}", customerId, firstName, lastName, phone, 
          newFirstName, newLastName, newPhone);
      
      return customerService.updateCustomers(customerId, firstName, lastName, phone,
          newFirstName, newLastName, newPhone);
    }
}
