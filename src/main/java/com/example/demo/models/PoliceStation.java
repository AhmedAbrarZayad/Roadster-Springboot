package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "police_station")
public class PoliceStation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int stationId;  // Java convention: camelCase
    public String name;
    public String contactInfo;  // Java convention: camelCase

    @Column(name = "Lmgrc_code")  // Map to your exact database column
    public String lmgrcCode;  // Java convention: camelCase

    // Default constructor (required by JPA)
    public PoliceStation() {}

    public PoliceStation(int stationId, String name, String contactInfo, String lmgrcCode) {
        this.stationId = stationId;
        this.name = name;
        this.contactInfo = contactInfo;
        this.lmgrcCode = lmgrcCode;
    }

    // Getters and Setters
    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
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
