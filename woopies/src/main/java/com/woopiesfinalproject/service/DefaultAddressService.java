package com.woopiesfinalproject.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.woopiesfinalproject.dao.AddressDao;
import com.woopiesfinalproject.entity.Address;
import com.woopiesfinalproject.entity.Customers;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultAddressService implements AddressService {
  @Autowired
  private AddressDao addressDao;

  //Get (read address)
  @Transactional(readOnly = true)
  @Override
  public List<Address> fetchAddress(Long addressPK, String customerId){
    log.info("The fetchAddress method was called with addressPK={}, customerId={}",
        addressPK, customerId);
    
    return addressDao.fetchAddress(addressPK, customerId);
  }

  //Post (create address)
  @Override
  public Optional<Address> createAddress(String customerId, String billingAddress, 
     String shippingAddress){
   
   log.info("The createAddress method was called with customerId={}, "
       + "billingAddress={}, shippingAddress={}", customerId, billingAddress, shippingAddress); 
   
   return addressDao.createAddress(customerId, billingAddress, shippingAddress); 

  }

  //Put (update address)
  @Override
  public Optional<Address> updateAddress(Long addressPK, String customerId, 
     String billingAddress, String shippingAddress){
   
   log.info("The updateAddress method was called with addressPK={}, customerId={}, billingAddress={},"
       + "shippingAddress", addressPK, customerId, billingAddress, shippingAddress);
   
   return addressDao.updateAddress(addressPK, customerId, billingAddress, shippingAddress); 
 
  }
}
