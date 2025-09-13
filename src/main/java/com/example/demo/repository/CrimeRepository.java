package com.example.demo.repository;

import com.example.demo.dto.CrimeCountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CrimeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<CrimeCountDTO> getCrimeCountByDistrict() {
        String sql = """
            SELECT l.district, COUNT(*) AS count
            FROM occured_at oa
            JOIN crime c ON oa.Ccrime_id = c.crime_id
            JOIN location l ON oa.Lmgrc_code = l.mgrc_code
            GROUP BY l.district
        """;

        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new CrimeCountDTO(
                        rs.getString("district"),
                        rs.getLong("count")
                )
        );
    }
}
