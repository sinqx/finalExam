package com.example.demo.service;

import com.example.demo.repository.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CitizenServiceImpl {
    @Autowired
    private CitizenRepository citizenRepository;
}
