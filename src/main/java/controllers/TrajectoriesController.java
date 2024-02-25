package com.example.demo.controller;

import com.example.demo.model.Trajectory;
import com.example.demo.service.TrajectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/trajectories")
public class TrajectoriesController {

    @Autowired
    private TrajectoryService trajectoryService;

    @GetMapping
    public List<Trajectory> getAllTrajectories() {
        return trajectoryService.getAllTrajectories();
    }
}
