package com.woopiesfinalproject.entity;
/* This class tracks the order status as the status of the order updates. 
 * Ideally, this class will allow create and read operations but no delete.
 * Want to keep history of each order and status as it changes.
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IndividualOrderStatus {
  private Long orderStatusPK;
  private Order order;
  private Customers customer;
  private OrderStatus orderStatus;
  private ShippingStatus shippingStatus;
  // Add time/date stamp for each individual order status!
}
