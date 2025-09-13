package com.example.demo.controller;

import com.example.demo.dto.AreaCrimeRateDTO;
import com.example.demo.service.AreaCrimeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/crime-rates")
public class AreaCrimeRateController {

    @Autowired
    private AreaCrimeRateService service;

    @GetMapping("/{district}")
    public List<AreaCrimeRateDTO> getCrimeRateByDistrict(@PathVariable String district) {
        return service.getCrimeRateByDistrict(district);
    }
}
