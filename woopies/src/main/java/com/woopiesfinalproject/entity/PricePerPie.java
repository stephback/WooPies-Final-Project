package com.woopiesfinalproject.entity;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/* This class contains the prices associated with pies and their respective sizes/types.
 * This class will have create, read, and update operations. These operations allow the
 * prices to be adjusted accordingly if/when the cost of ingredients increase.
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PricePerPie {
  private Long pricePerPiePK;
  private Pie pie;
  private BigDecimal pricePerPie;
}
