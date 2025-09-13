package com.example.demo.dto;

public class TrafficLevelDTO {
    private String trafficLevel;
    private Long areaCount;

    public TrafficLevelDTO(String trafficLevel, Long areaCount) {
        this.trafficLevel = trafficLevel;
        this.areaCount = areaCount;
    }

    public String getTrafficLevel() { return trafficLevel; }
    public Long getAreaCount() { return areaCount; }
}

