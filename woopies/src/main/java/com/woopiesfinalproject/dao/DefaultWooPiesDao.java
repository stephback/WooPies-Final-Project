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
import com.woopiesfinalproject.entity.Pie;
import com.woopiesfinalproject.entity.PieSize;
import com.woopiesfinalproject.entity.PieType;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultWooPiesDao implements WooPiesDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  
// Get method to read list of pies from WooPies database
  @Override
  public List<Pie> fetchPies(String pieId, PieSize pieSize) {
    log.info("DAO: pieID={}, pieSize={}", pieId, pieSize);
    
    //@formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM pies "
        + "WHERE pie_id = :pie_id AND pie_size = :pie_size";
    //@formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("pie_id", pieId);
    params.put("pie_size", pieSize.toString()); 
    //had to convert pieSize enum to String or else error occurs due to enum to String conversion
    
    return jdbcTemplate.query(sql, params, new RowMapper<>() {

 //Mapping every column name to corresponding instance variables within Pie table
      @Override
      public Pie mapRow(ResultSet rs, int rowNum) throws SQLException {
        //@formatter:off
        return Pie.builder()
            .piePK(rs.getLong("pie_pk"))
            .pieId(new String(rs.getString("pie_id")))
            .pieSize(PieSize.valueOf(rs.getString("pie_size")))
            .pieType(PieType.valueOf(rs.getString("pie_type")))
            .build();
        //@formatter:on
      }});
  }
  
// Post method to create new pies within pie table
  @Override
  public Optional<Pie> createPies(String pieID, PieSize pieSize, PieType pieType) {
    log.info("DAO: pieID={}, pieSize={}", pieID, pieSize);
    
    //@formatter:off
    String sql = ""
        + "INSERT INTO pies ("
        + "pie_id, pie_size, pie_type"
        + ") VALUES ("
        +  ":pie_id, :pie_size, :pie_type)";
    //@formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("pie_id", pieID);
    params.put("pie_size", pieSize.toString()); 
    params.put("pie_type", pieType.toString()); 
    //had to convert pieSize enum to String or else error occurs due to enum to String conversion
    
    jdbcTemplate.update(sql, params);
    return Optional.ofNullable(Pie.builder().pieId(pieID).pieSize(pieSize).pieType(pieType).build());
        }
     
// Put method to update pies within pie table
  @Override
  public Optional<Pie> updatePies(String pieId, PieSize pieSize, PieSize newPieSize) {
  log.info("DAO: pieID={}, pieSize={}", pieId, pieSize);
  
  //@formatter:off
  String sql = ""
      + "UPDATE pies SET pie_size = :new_pie_size "
      + "WHERE pie_id = :pie_id AND pie_size = :pie_size";
  
  // can add pie_type to update if switch savory vs sweet...need to recode params/sql
  
  //@formatter:on
  
  Map<String, Object> params = new HashMap<>();
  params.put("pie_id", pieId);
  params.put("pie_size", pieSize.toString());
  params.put("new_pie_size", newPieSize.toString());
  //had to convert pieSize enum to String or else error occurs due to enum to String conversion
  
  jdbcTemplate.update(sql, params);
  return Optional.ofNullable(Pie.builder().pieId(pieId).pieSize(newPieSize).build());
      }

@Override
public Optional<Pie> deletePies(String pieId, PieSize pieSize) {
  //@formatter:off
  String sql = ""
      + "DELETE FROM pies WHERE "
      + "pie_id = :pie_id AND "
      + "pie_size = :pie_size";
  //@formatter:on
  
  Map<String, Object> params = new HashMap<>();
  params.put("pie_id", pieId);
  params.put("pie_size", pieSize.toString());

  jdbcTemplate.update(sql, params); //returns number of rows affected
  //throw an exception here so if deleted value is re-deleted; it'll throw an error 
  return Optional.ofNullable(Pie.builder().pieId(pieId).pieSize(pieSize).build());
  }
}

// could use global error handler from jeepsales but do not need stack trace just message