package com.example.demo.service;

import com.example.demo.entity.Region;
import com.example.demo.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionServiceImpl implements RegionService{
    @Autowired
    private RegionRepository regionRepository;


    @Override
    public List<Region> findAll() {
        return regionRepository.findAll();
    }

    @Override
    public Region findById(Long id) {
        return regionRepository.findById(id).orElse(null);
    }
}
