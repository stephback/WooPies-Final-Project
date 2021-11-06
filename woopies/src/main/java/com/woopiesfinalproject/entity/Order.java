package com.woopiesfinalproject.entity;

import java.math.BigDecimal;
/* This class consists of all elements that make an order. 
 * This class will have create and read operations. 
 */
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
  private Long orderPK;
  private OrderItems orderItem;
  private Customers customer;
  private BigDecimal orderTotal;
  // Add time/date stamp for order class.
}
