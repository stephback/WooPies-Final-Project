package com.woopiesfinalproject.service;

import java.util.List;
import java.util.Optional;
import com.woopiesfinalproject.entity.Customers;

public interface CustomerService {

 /**
  * 
  * @param customerPK
  * @param customerId
  * @return
  */
 List<Customers> fetchCustomers(Long customerPK, String customerId);
 
 Optional<Customers> createCustomers(String customerId, String firstName, 
     String lastName, String phone);
 
 Optional<Customers> updateCustomers(String customerId, String firstName, String lastName, 
     String phone, String newFirstName,  String newLastName, String newPhone);
}
