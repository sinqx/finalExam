package com.example.demo.controller;

import com.example.demo.entity.Logs;
import com.example.demo.model.VaccineModel;
import com.example.demo.repository.LogsRepository;
import com.example.demo.service.LogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class LogsController {
    @Autowired
    private LogsService logsService;

    @GetMapping("/vaccinated")
    public List<Logs> getAllVaccinatedCitizens(@RequestBody LocalDateTime date){return logsService.getAllVaccinatedCitizens(date);}
 // Json - запрос писать просто "2021-10-09T22:54:54.330649500"
    @GetMapping("/infected")
    public List<Logs> getAllInfectedCitizens(@RequestBody LocalDateTime date){return logsService.getAllInfectedCitizens(date);}

    @PostMapping("/new/vaccine")
    public Logs createNewVaccinatedPost(@RequestBody VaccineModel vaccineModel){return logsService.createNewVaccinatedPost(vaccineModel);}

    @PostMapping("/new/vaccine/{citizenId}")
    public Logs createNewInfectedPost(@PathVariable Long citizenId){return logsService.createNewInfectedPost(citizenId);}

    @GetMapping
    public List<String> getStatistics(){return logsService.showTheStatistic();}
}
