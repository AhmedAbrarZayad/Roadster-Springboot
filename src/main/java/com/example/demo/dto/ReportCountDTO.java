package com.example.demo.dto;

public class ReportCountDTO {
    private String name;
    private Long count;

    public ReportCountDTO(String name, Long count) {
        this.name = name;
        this.count = count;
    }

    public String getName() { return name; }
    public Long getCount() { return count; }
}
