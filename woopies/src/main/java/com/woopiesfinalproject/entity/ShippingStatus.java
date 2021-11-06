package com.woopiesfinalproject.entity;

/* This class is an enumeration class to associate shipping status with each order 
 * once the order status indicates, "shipped". If order status != shipped, then
 * shipping status will be null.
 */

public enum ShippingStatus {
  PRE_TRANSIT, IN_TRANSIT, OUT_FOR_DELIVERY, DELIVERED
}
