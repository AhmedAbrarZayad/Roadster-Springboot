package com.example.demo.controller;
import com.example.demo.dto.CrimeCountDTO;
import com.example.demo.service.CrimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/crimes")
public class CrimeController {

    @Autowired
    private CrimeService crimeService;

    @GetMapping("/by-district")
    public List<CrimeCountDTO> getCrimeCountsByDistrict() {
        return crimeService.getCrimeCounts();
    }
}
