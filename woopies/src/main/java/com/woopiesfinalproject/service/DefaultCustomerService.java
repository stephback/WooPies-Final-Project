package com.woopiesfinalproject.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.woopiesfinalproject.dao.CustomerDao;
import com.woopiesfinalproject.entity.Customers;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultCustomerService implements CustomerService {
  
  @Autowired
  private CustomerDao customerDao;

// Get (read customers)
  @Transactional(readOnly = true)
  @Override
  public  List<Customers> fetchCustomers(Long customerPK, String customerId){
    log.info("The fetchCustomers method was called with customerPK={}, customerId={}",
        customerPK, customerId);
    
    return customerDao.fetchCustomers(customerPK, customerId);
  }
  
// Post (create customers)
 @Override
 public Optional<Customers> createCustomers(String customerId, String firstName, 
     String lastName, String phone){
   
   log.info("The createCustomers method was called with customerId={}, "
       + "firstName={}, lastName={}, phone={}",customerId, firstName, lastName, phone); 
   
   return customerDao.createCustomers(customerId, firstName, lastName, phone); 
  
 }

// Put (update customers)
 @Override
 public Optional<Customers> updateCustomers(String customerId, String firstName, String lastName, 
     String phone, String newFirstName, String newLastName, String newPhone){
   log.info("The updateCustomers method was called with customerId={}, firstName={}, lastName={}, "
       + "phone={}, newFirstName={}, newLastName={}, newPhone={}", customerId, firstName, lastName,
       phone, newFirstName, newLastName, newPhone);
   
   return customerDao.updateCustomers(customerId, firstName, lastName, phone, newFirstName, 
       newLastName, newPhone);
   }
}
