package com.example.demo.repository;

import com.example.demo.entity.Logs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

import java.util.List;

@Repository
public interface LogsRepository extends JpaRepository<Logs, Long> {
    List<Logs> findByRecordedIsBetweenAndCitizenVaccineIsNotNullOrderByCitizenRegionName(LocalDateTime startOfDay, LocalDateTime  endOfDay);
    List<Logs> findByRecordedIsBetweenAndCitizenInfectedTrueOrderByCitizenRegionName(LocalDateTime startOfDay, LocalDateTime  endOfDay);
}
