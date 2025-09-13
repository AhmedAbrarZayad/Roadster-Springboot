package com.example.demo.dto;

public class CrimeCountDTO {
    private String district;
    private Long count;

    public CrimeCountDTO(String district, Long count) {
        this.district = district;
        this.count = count;
    }

    public String getDistrict() { return district; }
    public Long getCount() { return count; }
}

