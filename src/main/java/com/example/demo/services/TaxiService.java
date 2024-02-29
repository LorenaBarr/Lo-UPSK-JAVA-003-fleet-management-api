package com.example.demo.services;

import com.example.demo.model.Taxi;
import com.example.demo.repositories.TaxiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaxiService {

    @Autowired
    private TaxiRepository taxiRepository;

    public List<Taxi> getAllTaxis() {
        return taxiRepository.findAll();
    }
}