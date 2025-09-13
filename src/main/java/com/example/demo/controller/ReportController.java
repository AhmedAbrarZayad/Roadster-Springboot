package com.example.demo.controller;

import com.example.demo.dto.ReportCountDTO;
import com.example.demo.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/{district}")
    public List<ReportCountDTO> getReportsByDistrict(@PathVariable String district) {
        return reportService.getReportsByDistrict(district);
    }
}

