package com.example.demo.dto;

public class AreaCongestionDTO {
    private String name;
    private String congestionLevel;

    public AreaCongestionDTO(String name, String congestionLevel) {
        this.name = name;
        this.congestionLevel = congestionLevel;
    }

    public String getName() {
        return name;
    }

    public String getCongestionLevel() {
        return congestionLevel;
    }
}
