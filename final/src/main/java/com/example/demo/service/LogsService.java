package com.example.demo.service;

import com.example.demo.entity.Logs;

import java.time.LocalDateTime;
import java.util.List;

public interface LogsService {
    List<Logs> getAllVaccinatedCitizens(LocalDateTime date);
    List<Logs> getAllInfectedCitizens(LocalDateTime date);
    Logs save(Logs log);
}
