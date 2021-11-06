package com.woopiesfinalproject.dao;

import java.util.List;
import java.util.Optional;
import com.woopiesfinalproject.entity.Address;
import com.woopiesfinalproject.entity.Customers;


public interface AddressDao {

//Method to read address from address table
  /**
   * 
   * @param addressPK
   * @param customerId
   * @return
   */
  List<Address> fetchAddress(Long addressPK, String customerId);

//Method to create address from address table
  /**
   * 
   * @param addressPK
   * @param customerId
   * @param billingAddress
   * @param shippingAddress
   * @return
   */
  Optional<Address> createAddress(String customerId, String billingAddress,
      String shippingAddress);

//Method to update address from address table
  /**
   * 
   * @param addressPK
   * @param customerId
   * @param billingAddress
   * @param shippingAddress
   * @return
   */
  Optional<Address> updateAddress(Long addressPK, String customerId, String billingAddress,
      String shippingAddress);
}
