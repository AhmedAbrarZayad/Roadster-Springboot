package com.example.demo.controller;

import com.example.demo.models.PoliceStation;
import com.example.demo.service.PoliceStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/police-stations")
public class PoliceController {
    @Autowired
    private PoliceStationService policeStationService;
    
    @GetMapping
    public List<PoliceStation> getAllPoliceStations() {
        return policeStationService.getAllPoliceStations();
    }

    @GetMapping("/with-districts")
    public List<Object[]> getPoliceStationsWithDistricts() {
        return policeStationService.getPoliceStationsWithDistrict();
    }
}
