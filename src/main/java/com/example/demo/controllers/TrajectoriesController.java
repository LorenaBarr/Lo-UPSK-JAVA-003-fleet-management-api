package com.example.demo.controllers;

import com.example.demo.model.Trajectory;
import com.example.demo.services.TrajectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/trajectories")
public class TrajectoriesController {

    @Autowired
    private TrajectoryService trajectoryService;

    @GetMapping
    public List<Trajectory> getAllTrajectories() {
        return trajectoryService.getAllTrajectories();
    }
}
