package com.example.demo.service;

import com.example.demo.entity.Citizen;
import com.example.demo.entity.Logs;
import com.example.demo.entity.Vaccine;
import com.example.demo.repository.LogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;


@Service
public class LogsServiceImpl implements LogsService{
    @Autowired
    private LogsRepository logsRepository;

    @Autowired
    private CitizenService citizenService;

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
    public Logs createNewVaccinatedPost(Long citizenId) {
        Citizen citizen =citizenService.findById(citizenId);
        Logs log = Logs.builder()
                .citizen(citizen)
                .recorded(LocalDateTime.now())
                .status("vaccinated by")
                .build();
        citizen.setVaccinated(true);
        citizenService.save(citizen);
        return logsRepository.save(log);
    }

    @Override
    public Logs createNewInfectedPost(Long citizenId) {
        Citizen citizen =citizenService.findById(citizenId);
        Logs log = Logs.builder()
                .citizen(citizen)
                .recorded(LocalDateTime.now())
                .status("infected")
                .build();
        citizen.setInfected(true);
        citizenService.save(citizen);
        return logsRepository.save(log);
    }

}
