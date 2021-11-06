//package com.woopiesfinalproject.dao;
//
//import java.math.BigDecimal;
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//import org.springframework.jdbc.support.GeneratedKeyHolder;
//import org.springframework.jdbc.support.KeyHolder;
//
//
//
//public class DefaultWooPieOrderDao implements WooPieOrderDao {
//
//  @Autowired
//  private NamedParameterJdbcTemplate jdbcTemplate;
//  
//}
/* Need to create order (Create, Read, Update)and somehow integrate orderItems,
 * customers, pies, price_per_pie, address(which should be directly linked to 
 * customers table), and order_status which should be coded to create a default
 * order status upon order creation. Will create these in near-future once I 
 * figure out how to do it. 
 */