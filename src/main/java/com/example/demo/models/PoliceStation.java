package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "police_station")
public class PoliceStation {

    @Id
    @Column(name = "station_id")
    private Integer stationId;

    @Column(name = "name")
    private String name;

    @Column(name = "contact_info")
    private String contactInfo;

    @Column(name = "Lmgrc_code")
    private String lmgrcCode;

    // Default constructor (required by JPA)
    public PoliceStation() {
    }

    public PoliceStation(Integer stationId, String name, String contactInfo, String lmgrcCode) {
        this.stationId = stationId;
        this.name = name;
        this.contactInfo = contactInfo;
        this.lmgrcCode = lmgrcCode;
    }

    // Getters and Setters
    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getLmgrcCode() {
        return lmgrcCode;
    }

    public void setLmgrcCode(String lmgrcCode) {
        this.lmgrcCode = lmgrcCode;
    }
}