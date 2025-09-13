package com.example.demo.repository;

import com.example.demo.dto.CrosswalkStatusDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CrosswalkRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<CrosswalkStatusDTO> getCrosswalkStatusByDistrict(String district) {
        String sql = """
            SELECT c.status, COUNT(*) AS count
            FROM crosswalk c
            JOIN location l ON c.Lmgrc_code = l.mgrc_code
            WHERE l.district = ?
            GROUP BY c.status
        """;

        return jdbcTemplate.query(sql, new Object[]{district}, (rs, rowNum) ->
                new CrosswalkStatusDTO(
                        rs.getString("status"),
                        rs.getLong("count")
                )
        );
    }
}

