package com.woopiesfinalproject.service;

import java.util.List;
import java.util.Optional;
import com.woopiesfinalproject.entity.Pie;
import com.woopiesfinalproject.entity.PieSize;
import com.woopiesfinalproject.entity.PieType;

/*
 *  Interface allows controller level to be built after interface created; this also allows 
 *  service layer to be built while controller is worked on. It makes mocking easier.
 */

public interface WooPiesService {

  /**
   * 
   * @param pieId
   * @param pieSize
   * @return
   */
  List<Pie> fetchPies(String pieId, PieSize pieSize);
  
  Optional<Pie> createPies(String pieId, PieSize pieSize, PieType pieType);
  
  Optional<Pie> updatePies(String pieId, PieSize pieSize, PieSize newPieSize);

  Optional<Pie> deletePies(String pieId, PieSize pieSize);
  
}
