package com.example.demo.service;

import com.example.demo.entity.Citizen;
import com.example.demo.repository.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CitizenServiceImpl implements CitizenService{
    @Autowired
    private CitizenRepository citizenRepository;

    @Override
    public Citizen save(Citizen citizen) {
        return null;
    }

    @Override
    public Citizen findById(Long id) {
        return citizenRepository.findById(id).orElse(null);
    }
}
