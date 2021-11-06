package com.woopiesfinalproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// The customer class will contain information associated with each customer.

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customers {
  private Long customerPK;
  private Address address;
  private String customerId;
  private String firstName;
  private String lastName;
  private String phone;
}
