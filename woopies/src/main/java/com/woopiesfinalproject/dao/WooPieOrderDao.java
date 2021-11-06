package com.woopiesfinalproject.dao;

import java.math.BigDecimal;
import java.util.Optional;
import com.woopiesfinalproject.entity.Customers;
import com.woopiesfinalproject.entity.Order;
import com.woopiesfinalproject.entity.OrderItems;

public interface WooPieOrderDao {
 Optional<OrderItems> fetchOrderItems();
 Optional<Customers> fetchCustomer(String custoemrId);
 
 Order saveOrder(OrderItems orderItem, Customers customer, BigDecimal price);
}
/* I am not certain if this dao needs to be fleshed out further to 
 * account for price_per_pie, quanitiy, etc. Although, price_per_pie
 * is an entity on it's own and quantity is addressed in the orderItems class.
 */ 