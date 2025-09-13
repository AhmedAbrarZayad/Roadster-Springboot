package com.example.demo.service;

import com.example.demo.dto.CrosswalkStatusDTO;
import com.example.demo.repository.CrosswalkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrosswalkService {

    @Autowired
    private CrosswalkRepository crosswalkRepository;

    public List<CrosswalkStatusDTO> getCrosswalkStatus(String district) {
        return crosswalkRepository.getCrosswalkStatusByDistrict(district);
    }
}
