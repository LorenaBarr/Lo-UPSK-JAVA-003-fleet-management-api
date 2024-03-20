package com.example.demo.repositories;
import com.example.demo.model.Taxi;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface TaxiRepository extends PagingAndSortingRepository<Taxi, Long> {



}

