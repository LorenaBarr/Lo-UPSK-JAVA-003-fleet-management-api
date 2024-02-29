package com.example.demo.repositories;

import com.example.demo.model.Trajectory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrajectoriesRepository extends JpaRepository<Trajectory, Long> {
}
