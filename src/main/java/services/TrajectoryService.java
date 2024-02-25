package com.example.demo.service;

import com.example.demo.model.Trajectory;
import com.example.demo.repository.TrajectoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TrajectoryService {

    @Autowired
    private TrajectoriesRepository trajectoriesRepository;

    public List<Trajectory> getAllTrajectories() {
        return trajectoriesRepository.findAll();
    }
}
