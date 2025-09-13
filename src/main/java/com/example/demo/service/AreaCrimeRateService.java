package com.example.demo.service;

import com.example.demo.dto.AreaCrimeRateDTO;
import com.example.demo.repository.AreaCrimeRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaCrimeRateService {

    @Autowired
    private AreaCrimeRateRepository repository;

    public List<AreaCrimeRateDTO> getCrimeRateByDistrict(String district) {
        return repository.getCrimeRateByDistrict(district);
    }
}
