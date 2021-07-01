package com.example.demo.service;

import com.example.demo.entity.Vaccine;
import com.example.demo.repository.VaccineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaccineServiceImpl implements VaccineService{
    @Autowired
    private VaccineRepository vaccineRepository;

    @Override
    public Vaccine findById(Long id) {
        return vaccineRepository.findById(id).orElse(null);
    }
}
