package com.example.demo.repositories;

import com.example.demo.dto.TaxiLastLocationDTO;
import com.example.demo.model.Taxi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxiRepository extends JpaRepository<Taxi, Long> {
    @Query("SELECT new com.example.demo.dto.TaxiLastLocationDTO(t.id, t.plate, traj.latitude, traj.longitude, traj.date) " +
            "FROM Taxi t " +
            "JOIN Trajectory traj " +
            "ON t.id = traj.taxiId " +
            "WHERE traj.date = (SELECT MAX(date) FROM Trajectory WHERE taxiId = t.id)")
    Page<TaxiLastLocationDTO> findLastLocationOfTaxis(Pageable pageable);
}