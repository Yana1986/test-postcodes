package com.example.postcodes.repository;

import com.example.postcodes.entity.Area;
import com.example.postcodes.entity.AreaId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AreaRepository extends JpaRepository<Area, AreaId> {

    List<Area> findByIdPostcodeBetween(String postcodeFrom, String postcodeTo);
}