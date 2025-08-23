package com.example.demo.service;

import com.example.demo.models.Area;
import com.example.demo.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaService {
    @Autowired
    private AreaRepository areaRepository;

    public List<Area> getAllAreas() {
        return areaRepository.findAll();
    }
    public Area getAreaById(int id) {
        return areaRepository.findById(id).orElse(null);
    }
}
