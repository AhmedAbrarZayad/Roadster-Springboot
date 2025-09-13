package com.example.demo.controller;

import com.example.demo.dto.AreaCongestionDTO;
import com.example.demo.service.AreaCongestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/area-congestion")
public class AreaCongestionController {

    @Autowired
    private AreaCongestionService areaService;

    @GetMapping("/{district}")
    public List<AreaCongestionDTO> getAreaCongestionByDistrict(@PathVariable String district) {
        return areaService.getAreaCongestionByDistrict(district);
    }
}
