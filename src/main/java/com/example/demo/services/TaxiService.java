package com.example.demo.services;

import com.example.demo.dto.TaxiLastLocationDTO;
import com.example.demo.model.Taxi;
import com.example.demo.model.Trajectory;
import com.example.demo.repositories.TaxiRepository;
import com.example.demo.repositories.TrajectoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaxiService {

    @Autowired
    private TaxiRepository taxiRepository;

    @Autowired
    private TrajectoriesRepository trajectoriesRepository;

    public List<Taxi> getAllTaxis() {
        return taxiRepository.findAll();
    }

    public List<TaxiLastLocationDTO> getLastLocationOfTaxis() {
        return taxiRepository.findAll().stream()
                .map(taxi -> {
                    Long taxiId = taxi.getId();
                    Trajectory lastTrajectory = trajectoriesRepository.findFirstByTaxiIdOrderByDateDesc(taxiId);
                    return new TaxiLastLocationDTO(
                            taxi.getId(),
                            taxi.getPlate(),
                            lastTrajectory.getLatitude(),
                            lastTrajectory.getLongitude(),
                            lastTrajectory.getDate()
                    );
                })
                .collect(Collectors.toList());
    }
}