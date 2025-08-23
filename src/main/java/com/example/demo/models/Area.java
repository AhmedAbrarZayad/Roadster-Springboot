package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "area")
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int area_id;
    @Column(nullable = true)
    public String name;
    @Column(nullable = true)
    public Double crime_rate;
    @Column(nullable = true)
    public Double congestion_level;
    @Column(nullable = true)
    public Double radius;
    @Column(nullable = true)
    public Integer Pstation_id;

    public Area(int area_id, String name, Double crime_rate, Double congestion_level, Double radius, Integer pstation_id) {
        this.area_id = area_id;
        this.name = name;
        this.crime_rate = crime_rate;
        this.congestion_level = congestion_level;
        this.radius = radius;
        Pstation_id = pstation_id;
    }
    public Area() {}

    public int getArea_id() {
        return area_id;
    }

    public void setArea_id(int area_id) {
        this.area_id = area_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCrime_rate() {
        return crime_rate;
    }

    public void setCrime_rate(Double crime_rate) {
        this.crime_rate = crime_rate;
    }

    public Double getCongestion_level() {
        return congestion_level;
    }

    public void setCongestion_level(Double congestion_level) {
        this.congestion_level = congestion_level;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public Integer getPstation_id() {
        return Pstation_id;
    }

    public void setPstation_id(Integer pstation_id) {
        Pstation_id = pstation_id;
    }

}
