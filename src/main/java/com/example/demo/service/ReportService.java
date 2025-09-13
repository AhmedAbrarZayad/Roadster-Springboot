package com.example.demo.service;

import com.example.demo.dto.ReportCountDTO;
import com.example.demo.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    public List<ReportCountDTO> getReportsByDistrict(String district) {
        return reportRepository.getReportsByDistrict(district);
    }
}
