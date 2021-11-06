package com.woopiesfinalproject.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.woopiesfinalproject.entity.Pie;
import com.woopiesfinalproject.entity.PieSize;
import com.woopiesfinalproject.entity.PieType;
import com.woopiesfinalproject.service.WooPiesService;
import lombok.extern.slf4j.Slf4j;

/*  This class is controller class that tells spring to marshal and unmarshal JSON to Java.
 *  This class also tells Spring to expect some controller mapping within application.
 */

@RestController
@Slf4j
public class DefaultWooPiesController implements WooPiesController {

  @Autowired
  private WooPiesService wooPiesService;
  
  // Get (read pies)
  @Override
  public List<Pie> fetchPies(String pieId, PieSize pieSize) {
    log.info("pieId={}, pieSize={}", pieId, pieSize); 
    
    return wooPiesService.fetchPies(pieId, pieSize); 
  }
  
  // Post (create pies)
  @Override
  public Optional<Pie> createPies(String pieId, PieSize pieSize, PieType pieType) {
    log.info("pieId={}, pieSize={}, pieType={}", pieId, pieSize, pieType); 
    
    return wooPiesService.createPies(pieId, pieSize, pieType); 
  }
  
  // Put (update pies)
  @Override
  public Optional<Pie> updatePies(String pieId, PieSize pieSize, PieSize newPieSize) {
    log.info("pieId={}, pieSize={}, newPieSize={}", pieId, pieSize, newPieSize); 
    
    return wooPiesService.updatePies(pieId, pieSize, newPieSize); 
  }

  // Delete pies
  @Override
  public Optional<Pie> deletePies(String pieId, PieSize pieSize) {
    log.info("pieId={}", pieId);
   
    return wooPiesService.deletePies(pieId, pieSize); 
  }
  
}
