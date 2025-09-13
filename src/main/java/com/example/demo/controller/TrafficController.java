package com.example.demo.controller;

import com.example.demo.dto.TrafficLevelDTO;
import com.example.demo.service.TrafficService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/traffic")
public class TrafficController {

    @Autowired
    private TrafficService trafficService;

    @GetMapping("/{district}")
    public List<TrafficLevelDTO> getTrafficByDistrict(@PathVariable String district) {
        return trafficService.getTrafficByDistrict(district);
    }
}

