package com.example.demo.dto;

public class AreaCrimeRateDTO {
    private String name;
    private Double crimeRate;

    public AreaCrimeRateDTO(String name, Double crimeRate) {
        this.name = name;
        this.crimeRate = crimeRate;
    }

    public String getName() {
        return name;
    }

    public Double getCrimeRate() {
        return crimeRate;
    }
}
