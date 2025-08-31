package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "location")
public class Location {

    @Id
    @Column(name = "mgrc_code", length = 100)
    private String mgrcCode;

    @Column(name = "type", length = 100)
    private String type;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "Aarea_id")
    private Integer AareaId;

    @Column(name = "district", length = 100)
    private String district;

    // Default constructor
    public Location() {
    }

    // Getters and Setters for all fields
    public String getMgrcCode() {
        return mgrcCode;
    }

    public void setMgrcCode(String mgrcCode) {
        this.mgrcCode = mgrcCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAareaId() {
        return AareaId;
    }

    public void setAareaId(Integer AareaId) {
        this.AareaId = AareaId;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}