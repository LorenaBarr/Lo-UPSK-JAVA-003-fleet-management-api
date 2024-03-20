package com.example.demo.services;


import com.example.demo.model.Taxi;
import com.example.demo.repositories.TaxiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;




@Service
public class TaxiService {
    private final TaxiRepository taxiRepository;

    @Autowired
    public TaxiService (TaxiRepository taxiRepository) {
        this.taxiRepository= taxiRepository;
    }

    public Page<Taxi> getAllTaxis(Pageable pageable){

        return taxiRepository.findAll(pageable);
    }
}