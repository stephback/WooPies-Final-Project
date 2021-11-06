package com.woopiesfinalproject.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.woopiesfinalproject.entity.Address;
import com.woopiesfinalproject.entity.Customers;
import com.woopiesfinalproject.service.AddressService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultAddressController implements AddressController {
  
  @Autowired 
  private AddressService addressService;
  
  @Override
  public List<Address> fetchAddress(Long addressPK, String customerId){
    log.info("The fetchAddress method was called with addressPK={}, customerId={}",
        addressPK, customerId);
    
    return addressService.fetchAddress(addressPK, customerId);
  }

  //Post (create address)
  @Override
  public Optional<Address> createAddress(String customerId, String billingAddress, 
     String shippingAddress){
   
   log.info("The createAddress method was called with customerId={}, "
       + "billingAddress={}, shippingAddress={}", customerId, billingAddress, shippingAddress); 
   
   return addressService.createAddress(customerId, billingAddress, shippingAddress); 

  }

  //Put (update address)
  @Override
  public Optional<Address> updateAddress(Long addressPK, String customerId, 
     String billingAddress, String shippingAddress){
   
   log.info("The updateAddress method was called with addressPK={}, customerId={}, billingAddress={},"
       + "shippingAddress", addressPK, customerId, billingAddress, shippingAddress);
   
   return addressService.updateAddress(addressPK, customerId, billingAddress, shippingAddress); 
  }
}
