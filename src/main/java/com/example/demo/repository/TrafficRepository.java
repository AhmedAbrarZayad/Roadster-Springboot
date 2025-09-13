package com.example.demo.repository;

import com.example.demo.dto.TrafficLevelDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TrafficRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<TrafficLevelDTO> getTrafficByDistrict(String district) {
        String sql = """
            SELECT
                CASE
                    WHEN a.congestion_level < 0.4 THEN 'Low Traffic'
                    WHEN a.congestion_level >= 0.4 AND a.congestion_level < 0.7 THEN 'Medium Traffic'
                    ELSE 'High Traffic'
                END AS traffic_level,
                COUNT(*) AS area_count
            FROM area a
            JOIN police_station ps ON a.Pstation_id = ps.station_id
            JOIN location l ON ps.Lmgrc_code = l.mgrc_code
            WHERE l.district = ?
            GROUP BY traffic_level
        """;

        return jdbcTemplate.query(sql, new Object[]{district}, (rs, rowNum) ->
                new TrafficLevelDTO(
                        rs.getString("traffic_level"),
                        rs.getLong("area_count")
                )
        );
    }
}
