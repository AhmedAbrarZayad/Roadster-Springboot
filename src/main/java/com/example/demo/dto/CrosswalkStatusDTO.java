package com.example.demo.dto;

public class CrosswalkStatusDTO {
    private String status;
    private Long count;

    public CrosswalkStatusDTO(String status, Long count) {
        this.status = status;
        this.count = count;
    }

    public String getStatus() { return status; }
    public Long getCount() { return count; }
}

