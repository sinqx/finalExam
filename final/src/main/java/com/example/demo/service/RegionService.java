package com.example.demo.service;

import com.example.demo.entity.Region;

import java.util.List;

public interface RegionService {
    List<Region> findAll();
    Region findById(Long id);
}
