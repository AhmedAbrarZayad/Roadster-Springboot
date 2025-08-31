package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "driver")
public class Driver {

    @Id
    @Column(name = "driver_id")
    private Integer driverId;

    @Column(name = "name")
    private String name;

    @Column(name = "license_number")
    private String licenseNumber;

    @Column(name = "contact_info")
    private String contactInfo;

    @Column(name = "district")
    private String district;

    // Default constructor (required by JPA)
    public Driver() {
    }

    // Constructor for creating new instances
    public Driver(Integer driverId, String name, String licenseNumber, String contactInfo, String district) {
        this.driverId = driverId;
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.contactInfo = contactInfo;
        this.district = district;
    }

    // Getters and Setters
    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}