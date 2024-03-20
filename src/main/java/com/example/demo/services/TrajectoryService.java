// TrajectoryService.java
package com.example.demo.services;

import com.example.demo.model.Trajectory;
import com.example.demo.repositories.TrajectoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageImpl;

import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public class TrajectoryService {

    private final TrajectoriesRepository trajectoriesRepository;

    @Autowired
    public TrajectoryService(TrajectoriesRepository trajectoriesRepository ) {
        this.trajectoriesRepository = trajectoriesRepository;
    }

    public Page<Trajectory> getAllTrajectories(Pageable pageable){
        return trajectoriesRepository.findAll(pageable);
    }

    public Page<Trajectory> findByDateAndId(int taxi_id, String dateString, Pageable pageable) {
        return trajectoriesRepository.findByTaxiIdAndDate(taxi_id, dateString, pageable);
    }

    // Método auxiliar para crear una solicitud de página
    private Pageable createPageRequestUsing(int page, int size) {
        return PageRequest.of(page, size);
    }

    public Page<Trajectory> getLastLocation(int page, int size) {
        Pageable pageRequest = createPageRequestUsing(page, size);

        List<Trajectory> allCustomers = trajectoriesRepository.findLastLocation();
        int start = (int) pageRequest.getOffset();
        int end = Math.min((start + pageRequest.getPageSize()), allCustomers.size());

        List<Trajectory> pageContent = allCustomers.subList(start, end);

        List<Trajectory> lastLocation = trajectoriesRepository.findLastLocation();
        return new PageImpl<>( pageContent, pageRequest, lastLocation.size());
    }
}