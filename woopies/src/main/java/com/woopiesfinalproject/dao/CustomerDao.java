package com.woopiesfinalproject.dao;

import java.util.List;
import java.util.Optional;
import com.woopiesfinalproject.entity.Customers;

public interface CustomerDao {

  // Method to read customers from customer table
 /**
 * 
 * @param customerPK
 * @param customerId
 * @return
 */
  List<Customers> fetchCustomers(Long customerPK, String customerId);
  
  // Method to create customers from customer table
  /**
   * 
   * @param customerPK
   * @param customerId
   * @param firstName
   * @param lastName
   * @param phone
   * @return
   */
  Optional<Customers> createCustomers(String customerId, String firstName, String lastName,
      String phone);
  
  // Method to update customers from customer table
  /**
   * 
   * @param customerId
   * @param firstName
   * @param lastName
   * @param phone
   * @param newFirstName
   * @param newLastName
   * @param newPhone
   * @return
   */
  Optional<Customers> updateCustomers(String customerId, String firstName, String lastName,
      String phone, String newFirstName, String newLastName, String newPhone);  
}
