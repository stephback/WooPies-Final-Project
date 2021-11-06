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
import com.woopiesfinalproject.entity.Customers;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultCustomerDao implements CustomerDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
 // Get method to read list of customers from WooPies database 
  @Override
  public List<Customers> fetchCustomers(Long customerPK, String customerId) {
    log.info("DAO: customerPK={}, customerId={}", customerPK, customerId);
    
    //@formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM customers "
        + "WHERE customer_pk = :customer_pk AND customer_id = :customer_id";
    //@formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("customer_pk", customerPK.toString());
    params.put("customer_id", customerId); 
    
    return jdbcTemplate.query(sql, params, new RowMapper<>() {

 //Mapping every column name to corresponding instance variables within Customers table
   @Override
   public Customers mapRow(ResultSet rs, int rowNum) throws SQLException {
        //@formatter:off
        return Customers.builder()
            .customerPK(rs.getLong("customer_pk"))
            .customerId(new String(rs.getString("customer_id")))
            .firstName(new String(rs.getString("first_name")))
            .lastName(new String(rs.getString("last_name")))
            .build();
        //@formatter:on
      }});
    }

// Post method to create new customer within customers table
   @Override
   public Optional<Customers> createCustomers(String customerId, String firstName, 
      String lastName, String phone) {
    log.info("DAO: customerId={}, firstName={}, lastName={}, phone={}",
           customerId, firstName, lastName, phone);
    
    //@formatter:off
    String sql = ""
        + "INSERT INTO customers ("
        + "customer_id, first_name, last_name, phone"
        + ") VALUES ("
        +  ":customer_id, :first_name, :last_name, :phone)";
    //@formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("customer_id", customerId);
    params.put("first_name", firstName); 
    params.put("last_name", lastName);
    params.put("phone", phone); 

    jdbcTemplate.update(sql, params);
    return Optional.ofNullable(Customers.builder()
        .customerId(customerId).firstName(firstName).lastName(lastName).phone(phone).build());
    }
 
// Put method to update customer within customers table
  @Override
  public Optional<Customers> updateCustomers(String customerId, String firstName, String lastName, 
      String phone, String newFirstName, String newLastName, String newPhone) {
    
    log.info("DAO: customerId={}, firstName={}, lastName={}, phone={}, newFirstName={}, "
        + "newLastName={}, newPhone={}", customerId, firstName, lastName, phone, 
        newFirstName, newLastName, newPhone);
    
    //@formatter:off
    String sql = ""
        + "UPDATE customers SET phone = :new_phone, "
        + "first_name = :new_first_name, "
        + "last_name = :new_last_name "
        + "WHERE customerId = :customer_id AND "
        + "first_name = :first_name AND "
        + "last_name = :last_name";
    
    //@formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("customer_id", customerId);
    params.put("first_name", firstName); 
    params.put("last_name", lastName);
    params.put("phone", phone); 
    params.put("new_first_name", newFirstName); 
    params.put("new_last_name", newLastName);
    params.put("new_phone", newPhone); 
    
    jdbcTemplate.update(sql, params);
    return Optional.ofNullable(Customers.builder()
        .customerId(customerId).firstName(newFirstName).lastName(newLastName).phone(newPhone).build());
    }
  }
