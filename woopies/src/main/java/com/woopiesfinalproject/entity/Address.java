package com.woopiesfinalproject.entity;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.woopiesfinalproject.dao.AddressDao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// The Address class will contain all addresses associated with each customer.

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {
  private Long addressPK;
  private Customers customer;
  private String billingAddress;
  private String shippingAddress;
}

