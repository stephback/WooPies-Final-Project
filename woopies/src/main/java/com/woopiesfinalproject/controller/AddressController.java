package com.woopiesfinalproject.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.woopiesfinalproject.entity.Address;
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
@RequestMapping("/Address")
@OpenAPIDefinition(info = @Info(title = "WooPies Address Service"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})

public interface AddressController {

//@formatter:off
  @Operation(
      summary = "Returns a list of addresses",
      description = "Returns a list of addresses given a required address PK and customer id",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A list of addresses is returned.", 
              content = @Content(
                  mediaType = "application/json", 
              schema = @Schema(implementation = Address.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid.", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No addresses were found with the input criteria.", 
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
              name = "addressPK", 
              allowEmptyValue = false, 
              required = false, 
              description = "The addressPK (i.e., '57')"), 
          @Parameter(
              name = "customerId",
              allowEmptyValue = false,
              required = false,
              description = "The customerId (i.e., 'pielover75')") 
     }
  )
  
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<Address> fetchAddress(
      Long addressPK, 
      String customerId);
  
  @Operation(
      summary = "Creates an address",
      description = "Create a address using the required customer id, billing address, "
          + "and shipping address.",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "An address is created!", 
              content = @Content(
                  mediaType = "application/json", 
              schema = @Schema(implementation = Address.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid.", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "Unable to create address with the input criteria.", 
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
              name = "billingAddress",
              allowEmptyValue = false,
              required = false,
              description = "The billing address (i.e., '123 Crust Lane')"),
          @Parameter(
              name = "shippingAddress",
              allowEmptyValue = false,
              required = false,
              description = "The shipping address (i.e., '456 A La Mode Loop')"),
      }
  )
  
  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  Optional<Address> createAddress(
      String customerId, 
      String billingAddress, 
      String shippingAddress);

  
  
  @Operation(
      summary = "Updates an address",
      description = "Update an address using the required customer id, billing address, "
          + "shipping address.",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "An address is updated!", 
              content = @Content(
                  mediaType = "application/json", 
              schema = @Schema(implementation = Address.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid.", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "Unable to update address with the input criteria.", 
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
              name = "billingAddress",
              allowEmptyValue = false,
              required = false,
              description = "The billing address (i.e., '123 Crust Lane')"),
          @Parameter(
              name = "shippingAddress",
              allowEmptyValue = false,
              required = false,
              description = "The shipping address (i.e., '456 A La Mode Loop')")
      }
  )
  
  @PutMapping
  @ResponseStatus(code = HttpStatus.OK)
  Optional<Address> updateAddress(Long addressPK, 
      String customerId, 
      String billingAddress,
      String shippingAddress);
}
