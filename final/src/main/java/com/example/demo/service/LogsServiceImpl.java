package com.example.demo.service;

import com.example.demo.entity.Logs;
import com.example.demo.repository.LogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Locale;

@Service
public class LogsServiceImpl implements LogsService{
    @Autowired
    private LogsRepository logsRepository;

    @Override
    public List<Logs> getAllVaccinatedCitizens(LocalDateTime startDate) {
        LocalDateTime endOfDay = startDate.plusDays(1);
        return logsRepository.findByRecordedIsBetweenAndCitizenVaccinatedTrueOrderByCitizenRegionName(startDate, endOfDay);
    }

    @Override
    public List<Logs> getAllInfectedCitizens(LocalDateTime startDate) {
        LocalDateTime endOfDay = startDate.plusDays(1);
        return logsRepository.findByRecordedIsBetweenAndCitizenInfectedTrueOrderByCitizenRegionName(startDate, endOfDay);
    }

    @Override
    public Logs save(Logs log) {
        return null;
    }
}
