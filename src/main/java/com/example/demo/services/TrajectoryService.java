// TrajectoryService.java
package com.example.demo.services;

import com.example.demo.model.Trajectory;
import com.example.demo.repositories.TrajectoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrajectoryService {

    @Autowired
    private TrajectoriesRepository trajectoriesRepository;

    public Page<Trajectory> getAllTrajectories(int page, int size) {
        return trajectoriesRepository.findAll(PageRequest.of(page, size));
    }

    public List<Trajectory> getAllTrajectories() {
        return trajectoriesRepository.findAll();
    }

    public Trajectory getLastTrajectoryOfTaxi(Long taxiId) {
        return trajectoriesRepository.findFirstByTaxiIdOrderByDateDesc(taxiId);
    }


}
