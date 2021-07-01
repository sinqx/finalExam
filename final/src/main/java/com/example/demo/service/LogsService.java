package com.example.demo.service;

import com.example.demo.entity.Logs;
import com.example.demo.entity.Vaccine;
import com.example.demo.model.VaccineModel;

import java.time.LocalDateTime;
import java.util.List;

public interface LogsService {
    List<Logs> getAllVaccinatedCitizens(LocalDateTime date);
    List<Logs> getAllInfectedCitizens(LocalDateTime date);
    Logs createNewVaccinatedPost(VaccineModel vaccineModel);
    Logs createNewInfectedPost(Long citizenId);
    List<String> showTheStatistic();
}
