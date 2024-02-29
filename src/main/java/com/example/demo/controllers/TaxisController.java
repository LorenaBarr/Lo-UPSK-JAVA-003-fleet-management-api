package com.example.demo.controllers;

import com.example.demo.services.TaxiService;
import com.example.demo.model.Taxi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/taxis")
public class TaxisController {

    @Autowired
    private TaxiService taxiService;

    @GetMapping
    public List<Taxi> getAllTaxis() {
        return taxiService.getAllTaxis();
    }
}