package com.example.demo.service;

import com.example.demo.dto.CrimeCountDTO;
import com.example.demo.repository.CrimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrimeService {

    @Autowired
    private CrimeRepository crimeRepository;

    public List<CrimeCountDTO> getCrimeCounts() {
        return crimeRepository.getCrimeCountByDistrict();
    }
}

