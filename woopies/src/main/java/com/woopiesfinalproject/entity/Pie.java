package com.woopiesfinalproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// This class contains all options for pie (e.g. Apple, 2 - inch, sweet, is gluten free).

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor


public class Pie {
  private Long piePK;
  private String pieId;
  private PieSize pieSize;
  private PieType pieType;
  
//  //Overriding lombok get-method so prior primary key cannot be viewed. 
////  @JsonIgnore
//  public Long getPiePK() {
//    return piePK;
//  }

}
