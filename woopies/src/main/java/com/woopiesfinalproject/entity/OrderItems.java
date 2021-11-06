package com.woopiesfinalproject.entity;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/* This class consists of each order item that will be placed/tracked into each order.
 * This class will have the create, read, and update operations.
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItems {
  private Long orderItemPK;
  private List<Pie> pies;
  private PricePerPie pricePerPie;
}
