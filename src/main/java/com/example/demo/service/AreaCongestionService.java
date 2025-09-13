package com.example.demo.service;

import com.example.demo.dto.AreaCongestionDTO;
import com.example.demo.repository.AreaCongestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaCongestionService {

    @Autowired
    private AreaCongestionRepository areaRepository;

    public List<AreaCongestionDTO> getAreaCongestionByDistrict(String district) {
        return areaRepository.getAreaCongestionByDistrict(district);
    }
}

