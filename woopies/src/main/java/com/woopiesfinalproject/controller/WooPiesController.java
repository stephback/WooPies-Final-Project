package com.woopiesfinalproject.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.woopiesfinalproject.entity.Order;
import com.woopiesfinalproject.entity.Pie;
import com.woopiesfinalproject.entity.PieSize;
import com.woopiesfinalproject.entity.PieType;
import io.swagger.v3.core.util.Constants;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/Pies") 
@OpenAPIDefinition(info = @Info(title = "WooPies Service"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})

public interface WooPiesController {
  //@formatter:off
  @Operation(
      summary = "Returns a list of pies",
      description = "Returns a list of pies given a required pie and pie size and pie type",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A list of pies is returned.", 
              content = @Content(
                  mediaType = "application/json", 
              schema = @Schema(implementation = Pie.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid.", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No pies were found with the input criteria.", 
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
              name = "pieId", 
              allowEmptyValue = false, 
              required = false, 
              description = "The pie type (i.e., 'APPLE')"), 
          @Parameter(
              name = "pieSize",
              allowEmptyValue = false,
              required = false,
              description = "The pie size (i.e., 'TWO INCH')") 
     }
  )
  
  //Get method (Read) 
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<Pie> fetchPies(
      @RequestParam(required = false) 
      String pieId,
      @RequestParam(required = false)
      PieSize pieSize);
 
  @Operation(
      summary = "Creates a pie",
      description = "Create a pie using a required pie and pie size",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A pie is created!", 
              content = @Content(
                  mediaType = "application/json", 
              schema = @Schema(implementation = Pie.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid.", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "Unable to create pie with the input criteria.", 
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
              name = "pieId", 
              allowEmptyValue = false, 
              required = false, 
              description = "The pie type (i.e., 'APPLE')"), 
          @Parameter(
              name = "pieSize",
              allowEmptyValue = false,
              required = false,
              description = "The pie size (i.e., 'TWO INCH')"),
          @Parameter(
              name = "pieType",
              allowEmptyValue = false,
              required = false,
              description = "The pie flavor (i.e., 'SAVORY')")
      }
  )
  
  // Post method (Create)
  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  Optional<Pie> createPies(
     @RequestParam(required = false) 
     String pieId,
     @RequestParam(required = false)
     PieSize pieSize,
     @RequestParam(required = false)
     PieType pieType);  
  
  @Operation(
      summary = "Updates a pie",
      description = "Update a pie using a required pie, pie size, and pie type",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A pie is updated!", 
              content = @Content(
                  mediaType = "application/json", 
              schema = @Schema(implementation = Pie.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid.", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "Unable to update pie with the input criteria.", 
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
              name = "pieId", 
              allowEmptyValue = false, 
              required = false, 
              description = "The pie type (i.e., 'APPLE')"), 
          @Parameter(
              name = "pieSize",
              allowEmptyValue = false,
              required = false,
              description = "The pie size (i.e., 'TWO INCH')"),
          @Parameter(
              name = "pieType",
              allowEmptyValue = false,
              required = false,
              description = "The pie flavor (i.e., 'SAVORY')")
      }
  )
  
  // Put method (Update)
 @PutMapping
 @ResponseStatus(code = HttpStatus.OK)
 Optional<Pie> updatePies(
     @RequestParam(required = false) 
     String pieId,
     @RequestParam(required = false)
     PieSize pieSize,
     @RequestParam(required = false)
     PieSize newPieSize);
  
 @Operation(
     summary = "Deletes a pie",
     description = "Delete a pie given a required pie and pie size",
     responses = {
         @ApiResponse(
             responseCode = "200", 
             description = "A pie is deleted.", 
             content = @Content(
                 mediaType = "application/json", 
             schema = @Schema(implementation = Pie.class))),
         @ApiResponse(
             responseCode = "400", 
             description = "The request parameters are invalid.", 
             content = @Content(
                 mediaType = "application/json")),
         @ApiResponse(
             responseCode = "404", 
             description = "No pies were found with the input criteria.", 
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
             name = "pieId", 
             allowEmptyValue = false, 
             required = false, 
             description = "The pie type (i.e., 'APPLE')"), 
         @Parameter(
             name = "pieSize",
             allowEmptyValue = false,
             required = false,
             description = "The pie size (i.e., 'TWO INCH')") 
     }
 )
  // Delete method (Delete)
  @DeleteMapping
  @ResponseStatus(code = HttpStatus.OK)
  Optional<Pie> deletePies(
      @RequestParam(required = false) 
      String pieId,
      @RequestParam(required = false)
      PieSize pieSize);
  
  //@formatter:on
}
