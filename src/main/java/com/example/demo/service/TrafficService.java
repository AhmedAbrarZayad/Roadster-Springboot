package com.example.demo.service;

import com.example.demo.dto.TrafficLevelDTO;
import com.example.demo.repository.TrafficRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrafficService {

    @Autowired
    private TrafficRepository trafficRepository;

    public List<TrafficLevelDTO> getTrafficByDistrict(String district) {
        return trafficRepository.getTrafficByDistrict(district);
    }
}

