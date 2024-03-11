package com.example.demo.services;

import com.example.demo.dto.TaxiLastLocationDTO;
import com.example.demo.model.Taxi;
import com.example.demo.model.Trajectory;
import com.example.demo.repositories.TaxiRepository;
import com.example.demo.repositories.TrajectoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaxiService {

    @Autowired
    private TaxiRepository taxiRepository;

    @Autowired
    private TrajectoriesRepository trajectoriesRepository;

    public Page<TaxiLastLocationDTO> getLastLocationOfTaxis(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Taxi> taxisPage = taxiRepository.findAll(pageable);
        return taxisPage.map(taxi -> {
            Long taxiId = taxi.getId();
            Trajectory lastTrajectory = trajectoriesRepository.findFirstByTaxiIdOrderByDateDesc(taxiId);
            LocalDateTime date = LocalDateTime.parse(lastTrajectory.getDate(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            return new TaxiLastLocationDTO(
                    taxi.getId(),
                    taxi.getId(),
                    taxi.getPlate(),
                    date,
                    lastTrajectory.getLatitude(),
                    lastTrajectory.getLongitude()
            );
        });
    }
}