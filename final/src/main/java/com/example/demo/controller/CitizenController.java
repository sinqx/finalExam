package com.example.demo.controller;

import com.example.demo.entity.Citizen;
import com.example.demo.repository.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/citizens")
public class CitizenController {
    @Autowired
    private CitizenRepository citizenRepository;

    @PostMapping
    public Citizen save(@RequestBody Citizen citizen){return citizenRepository.save(citizen);}

}
