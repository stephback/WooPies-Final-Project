package com.woopiesfinalproject.dao;

import java.util.List;
import java.util.Optional;
import com.woopiesfinalproject.entity.Pie;
import com.woopiesfinalproject.entity.PieSize;
import com.woopiesfinalproject.entity.PieType;

public interface WooPiesDao {

  // Method to read pies from pie table
  /**
   * 
   * @param pieId
   * @param pieSize
   * @param pieType
   * @return
   */
  List<Pie> fetchPies(String pieId, PieSize pieSize);

  // Method to create pies in pie table
  /**
   * 
   * @param pieId
   * @param pieSize
   * @param pieType
   * @return
   */
  Optional<Pie> createPies(String pieId, PieSize pieSize, PieType pieType);
  
  // Method to update pies in pie table
  /**
   * 
   * @param pieId
   * @param pieSize
   * @param pieType
   * @return
   */
  Optional<Pie> updatePies(String pieId, PieSize pieSize, PieSize newPieSize);

  /**
   * 
   * @param pieId
   * @param pieSize
   * @return
   */
  Optional<Pie> deletePies(String pieId, PieSize pieSize);
  
}
