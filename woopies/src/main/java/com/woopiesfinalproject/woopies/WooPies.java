package com.woopiesfinalproject.woopies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.woopiesfinalproject.ComponentScanMarker;

//Starts spring boot application

@SpringBootApplication(scanBasePackageClasses = {ComponentScanMarker.class})
public class WooPies {

  public static void main(String[] args) {
    SpringApplication.run(WooPies.class, args);
  }
}
