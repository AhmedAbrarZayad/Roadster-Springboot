package com.example.demo.repository;

import com.example.demo.models.PoliceStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PoliceRepository extends JpaRepository<PoliceStation, Integer> {
    @Query("SELECT ps.name, l.district FROM PoliceStation ps JOIN Location l ON ps.lmgrcCode = l.mgrcCode")
    List<Object[]> findPoliceStationNameAndDistrict();
}
