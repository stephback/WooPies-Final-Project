package com.woopiesfinalproject.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.woopiesfinalproject.entity.Address;
import com.woopiesfinalproject.entity.Customers;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultAddressDao implements AddressDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
 // Get method to read list of customers from WooPies database 
  @Override
  public List<Address> fetchAddress(Long addressPK, String customerId) {
    log.info("DAO: addressPK={}, customerId={}", addressPK, customerId);

    //@formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM address "
        + "WHERE address_pk = :address_pk AND customer_id = :customer_id";
    //@formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("address_pk", addressPK.toString());
    params.put("customer_id", customerId); 
    
    return jdbcTemplate.query(sql, params, new RowMapper<>() {

 //Mapping every column name to corresponding instance variables within Address table
   @Override
   public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
        //@formatter:off
        return Address.builder()
            .addressPK(rs.getLong("address_pk"))
            .billingAddress(new String(rs.getString("billing_address")))
            .shippingAddress(new String(rs.getString("shipping_address")))
            .build();
        //@formatter:on
      }});
  }

  @Override
  public Optional<Address> createAddress(String customerId, String billingAddress,
      String shippingAddress) {
    log.info("DAO: customerId={}, billingAddress={}, shippingAddress={}",
        customerId, billingAddress, shippingAddress);
 
   //@formatter:off
   String sql = ""
     + "INSERT INTO address ("
     + "customer_id, billing_address, shipping_address"
     + ") VALUES ("
     +  ":customer_id, :billing_address, :shipping_address)";
   //@formatter:on
 
  Map<String, Object> params = new HashMap<>();
  params.put("customer_id", customerId);
  params.put("billing_address", billingAddress); 
  params.put("shipping_address", shippingAddress); 

 jdbcTemplate.update(sql, params);
 return Optional.ofNullable(Address.builder()
     .billingAddress(billingAddress).shippingAddress(shippingAddress).build());
 }

  @Override
  public Optional<Address> updateAddress(Long addressPK, String customerId,
      String billingAddress, String shippingAddress) {
    log.info("DAO: addressPK={}, customerId={}, billingAddress={}, shippingAddress={}", 
        addressPK, customerId, billingAddress, shippingAddress);
    
    //@formatter:off
    String sql = ""
        + "UPDATE address SET billingAddress = :billing_address,"
        + "shipping_address = :shipping_address "
        + "WHERE addressPK = :addressPK AND "
        + "customerId = :customer_id AND "
        + "billingAddress = :billingAddress AND "
        + "shippingAddress = :shippingAddress";
    
    //@formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("address_pk", addressPK);
    params.put("customer_id", customerId);
    params.put("billing_address", billingAddress); 
    params.put("shipping_address", shippingAddress); 
    
    jdbcTemplate.update(sql, params);
    return Optional.ofNullable(Address.builder()
        .addressPK(addressPK).billingAddress(billingAddress)
        .shippingAddress(shippingAddress).build());
  }
}
