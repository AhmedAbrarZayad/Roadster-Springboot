package com.example.demo.repository;

import com.example.demo.dto.AreaCrimeRateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AreaCrimeRateRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<AreaCrimeRateDTO> getCrimeRateByDistrict(String district) {
        String sql = """
            SELECT area.name,crime_rate
            FROM area JOIN police_station ON Pstation_id = station_id
            JOIN location ON Lmgrc_code = mgrc_code
            WHERE district = ?
        """;

        return jdbcTemplate.query(sql, new Object[]{district}, (rs, rowNum) ->
                new AreaCrimeRateDTO(
                        rs.getString("name"),
                        rs.getDouble("crime_rate")
                )
        );
    }
}
