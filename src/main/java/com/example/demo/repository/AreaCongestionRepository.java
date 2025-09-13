package com.example.demo.repository;

import com.example.demo.dto.AreaCongestionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AreaCongestionRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<AreaCongestionDTO> getAreaCongestionByDistrict(String district) {
        String sql = """
            SELECT area.name, area.congestion_level
            FROM area 
            JOIN police_station ON area.Pstation_id = police_station.station_id
            JOIN location ON police_station.Lmgrc_code = location.mgrc_code
            WHERE location.district = ?
        """;

        return jdbcTemplate.query(sql, new Object[]{district}, (rs, rowNum) ->
                new AreaCongestionDTO(
                        rs.getString("name"),
                        rs.getString("congestion_level")
                )
        );
    }
}
