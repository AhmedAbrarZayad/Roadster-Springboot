package com.example.demo.service;

import com.example.demo.models.Location;
import com.example.demo.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    public Location getLocationById(String mgrcCode) {
        return locationRepository.findById(mgrcCode).orElse(null);
    }
}