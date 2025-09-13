package com.example.demo.controller;

import com.example.demo.dto.CrosswalkStatusDTO;
import com.example.demo.service.CrosswalkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/crosswalks")
public class CrosswalkController {

    @Autowired
    private CrosswalkService crosswalkService;

    @GetMapping("/{district}")
    public List<CrosswalkStatusDTO> getCrosswalkStatus(@PathVariable String district) {
        return crosswalkService.getCrosswalkStatus(district);
    }
}

