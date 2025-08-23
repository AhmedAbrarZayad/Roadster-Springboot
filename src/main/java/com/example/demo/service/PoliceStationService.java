package com.example.demo.service;

import com.example.demo.models.PoliceStation;
import com.example.demo.repository.PoliceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoliceStationService {
    @Autowired
    private PoliceRepository policeRepository;

    public List<PoliceStation> getAllPoliceStations() {
        return policeRepository.findAll();
    }
    public PoliceStation getPoliceStationById(int id) {
        return policeRepository.findById(id).orElse(null);
    }
}
