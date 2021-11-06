package com.woopiesfinalproject.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.woopiesfinalproject.entity.Customers;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/Customers")
@OpenAPIDefinition(info = @Info(title = "WooPies Customer Service"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})

public interface CustomerController {
//@formatter:off
  @Operation(
      summary = "Returns a list of customers",
      description = "Returns a list of customers given a required customer id and optional customerPK",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A list of customers is returned.", 
              content = @Content(
                  mediaType = "application/json", 
              schema = @Schema(implementation = Customers.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid.", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No customers were found with the input criteria.", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred.", 
              content = @Content(
                  mediaType = "application/json"))
      },
      parameters = {
          @Parameter(
              name = "customerPK", 
              allowEmptyValue = false, 
              required = false, 
              description = "The customerPK (i.e., '24')"), 
          @Parameter(
              name = "customerId",
              allowEmptyValue = false,
              required = false,
              description = "The customerId (i.e., 'pielover75')") 
     }
  )
  
  // Get method (read)
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<Customers> fetchCustomers(
      @RequestParam(required = false)
      Long customerPK, 
      @RequestParam(required = false)
      String customerId);

  @Operation(
      summary = "Creates a customer",
      description = "Create a customer using the required customer id, first name, "
          + "last name, and phone number.",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A customer is created!", 
              content = @Content(
                  mediaType = "application/json", 
              schema = @Schema(implementation = Customers.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid.", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "Unable to create customer with the input criteria.", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred.", 
              content = @Content(
                  mediaType = "application/json"))
      },
      parameters = {
          @Parameter(
              name = "customerId", 
              allowEmptyValue = false, 
              required = false, 
              description = "The customer id (i.e., 'pielover75')"), 
          @Parameter(
              name = "firstName",
              allowEmptyValue = false,
              required = false,
              description = "The first name (i.e., 'Jane')"),
          @Parameter(
              name = "lastName",
              allowEmptyValue = false,
              required = false,
              description = "The last name (i.e., 'Dough')"),
          @Parameter(
              name = "phone",
              allowEmptyValue = false,
              required = false,
              description = "The phone number (i.e., '846-336-7743')")
      }
  )
 
  // Post method (create)
  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  Optional<Customers> createCustomers(
      @RequestParam(required = false)
      String customerId, 
      @RequestParam(required = false)
      String firstName,
      @RequestParam(required = false)
      String lastName, 
      @RequestParam(required = false)
      String phone);

  @Operation(
      summary = "Updates a customer",
      description = "Update a customer using the required customer id, first name, "
          + "last name, and phone number.",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A customer is updated!", 
              content = @Content(
                  mediaType = "application/json", 
              schema = @Schema(implementation = Customers.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid.", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "Unable to update customer with the input criteria.", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred.", 
              content = @Content(
                  mediaType = "application/json"))
      },
      parameters = {
          @Parameter(
              name = "customerId", 
              allowEmptyValue = false, 
              required = false, 
              description = "The customer id (i.e., 'pielover75')"), 
          @Parameter(
              name = "firstName",
              allowEmptyValue = false,
              required = false,
              description = "The first name (i.e., 'Jane')"),
          @Parameter(
              name = "lastName",
              allowEmptyValue = false,
              required = false,
              description = "The last name (i.e., 'Dough')"),
          @Parameter(
              name = "phone",
              allowEmptyValue = false,
              required = false,
              description = "The phone number (i.e., '846-336-7743')")
      }
  )
  
  //Put method (update)
  @PutMapping
  @ResponseStatus(code = HttpStatus.OK)
  Optional<Customers> updateCustomers(
      @RequestParam(required = false)
      String customerId,
      @RequestParam(required = false)
      String firstName,
      @RequestParam(required = false)
      String lastName,
      @RequestParam(required = false)
      String phone, 
      @RequestParam(required = false)
      String newFirstName, 
      @RequestParam(required = false)
      String newLastName, 
      @RequestParam(required = false)
      String newPhone);
}
