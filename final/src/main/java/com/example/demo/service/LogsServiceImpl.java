package com.example.demo.service;

import com.example.demo.entity.Citizen;
import com.example.demo.entity.Logs;
import com.example.demo.entity.Vaccine;
import com.example.demo.model.VaccineModel;
import com.example.demo.repository.LogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class LogsServiceImpl implements LogsService {
    @Autowired
    private LogsRepository logsRepository;

    @Autowired
    private CitizenService citizenService;

    @Autowired
    private VaccineService vaccineService;

    @Autowired
    private RegionService regionService;

    @Override
    public List<Logs> getAllVaccinatedCitizens(LocalDateTime startDate) {
        LocalDateTime endOfDay = startDate.plusDays(1);
        return logsRepository.findByRecordedIsBetweenAndCitizenVaccineIsNotNullOrderByCitizenRegionName(startDate, endOfDay);
    }

    @Override
    public List<Logs> getAllInfectedCitizens(LocalDateTime startDate) {
        LocalDateTime endOfDay = startDate.plusDays(1);
        return logsRepository.findByRecordedIsBetweenAndCitizenInfectedTrueOrderByCitizenRegionName(startDate, endOfDay);
    }

    @Override
    public Logs createNewVaccinatedPost(VaccineModel vaccineModel) {
        Citizen citizen = citizenService.findById(vaccineModel.getCitizenId());
        Vaccine vaccine = vaccineService.findById(vaccineModel.getVaccineId());
        Logs log = Logs.builder()
                .citizen(citizen)
                .recorded(LocalDateTime.now())
                .status("vaccinated by")
                .build();
        citizen.setVaccine(vaccine);
        citizenService.save(citizen);
        return logsRepository.save(log);
    }

    @Override
    public Logs createNewInfectedPost(Long citizenId) {
        Citizen citizen = citizenService.findById(citizenId);
        Logs log = Logs.builder()
                .citizen(citizen)
                .recorded(LocalDateTime.now())
                .status("infected")
                .build();
        citizen.setInfected(true);
        citizenService.save(citizen);
        return logsRepository.save(log);
    }

    @Override
    public List<String> showTheStatistic() {
        List<String> Vaccinated = null;
        for (int i = 0; i < regionService.findAll().size(); i++) {
            int cityVaccinated = logsRepository.countAllByCitizenRegionIdAndCitizenVaccineIsNotNull((long) i);
            int cityInfected = logsRepository.countAllByCitizenRegionIdAndCitizenInfectedTrue((long) i);
            int cityPopulation = regionService.findById((long) i).getPopulation();
            assert false;
            Vaccinated.add("Население в городе" + regionService.findById((long) i).getName() +
                    "числится в " + cityPopulation + ".\n" +
                    "Число привившихся составляет - " + cityVaccinated + " Человек. " +
                    "Больных - " + cityInfected + "человек." +
                    "Процент инфецированных - " + 100 / cityPopulation / cityInfected + "%\n" +
                    "Процент вакцинированных - " + 100 / cityPopulation / cityVaccinated);
        }
        return Vaccinated;
    }
}
