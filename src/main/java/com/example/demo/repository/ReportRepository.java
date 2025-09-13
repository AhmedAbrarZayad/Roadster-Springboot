package com.example.demo.repository;

import com.example.demo.dto.ReportCountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReportRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<ReportCountDTO> getReportsByDistrict(String district) {
        String sql = """
            SELECT l.name, COUNT(*) AS count
            FROM reported_at ra
            JOIN report r ON ra.Rreport_id = r.report_id
            JOIN location l ON ra.Lmgrc_code = l.mgrc_code
            WHERE l.district = ?
            GROUP BY l.name
        """;

        return jdbcTemplate.query(sql, new Object[]{district}, (rs, rowNum) ->
                new ReportCountDTO(
                        rs.getString("name"),
                        rs.getLong("count")
                )
        );
    }
}

