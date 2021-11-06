package com.woopiesfinalproject.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.woopiesfinalproject.dao.WooPiesDao;
import com.woopiesfinalproject.entity.Pie;
import com.woopiesfinalproject.entity.PieSize;
import com.woopiesfinalproject.entity.PieType;
import lombok.extern.slf4j.Slf4j;

// Service tells Spring to manage(bean) defaultWooPies service b/c it is a candidate for injection
// WooPiesService interface

@Service
@Slf4j
public class DefaultWooPiesService implements WooPiesService {
  
  @Autowired
  private WooPiesDao wooPiesDao;

// Get (read pies)
  @Transactional(readOnly = true)
  @Override
  public List<Pie> fetchPies(String pieId, PieSize pieSize) {
    log.info("The fetchPies method was called with pieId={} and pieSize={}", pieId, pieSize);
    
    return wooPiesDao.fetchPies(pieId, pieSize);
  }
  
// Post (create pies)
 @Override
 public Optional<Pie> createPies(String pieId, PieSize pieSize, PieType pieType) {
   log.info("The createPies method was called with pieId={}, pieSize={}, pieType={}", pieId, pieSize, pieType); 
   
   return wooPiesDao.createPies(pieId, pieSize, pieType); 
 }

// Put (update pies)
 @Override
 public Optional<Pie> updatePies(String pieId, PieSize pieSize, PieSize newPieSize) {
   log.info("The updatePies method was called with pieId={}, pieSize={}", pieId, pieSize); 
   
   return wooPiesDao.updatePies(pieId, pieSize, newPieSize); 
 }

@Override
public Optional<Pie> deletePies(String pieId, PieSize pieSize) {
 
  return wooPiesDao.deletePies(pieId, pieSize); 
}

}
