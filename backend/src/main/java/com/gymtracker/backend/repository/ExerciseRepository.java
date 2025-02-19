package com.gymtracker.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gymtracker.backend.entity.Exercise;


public interface ExerciseRepository extends JpaRepository<Exercise, Long>{

}
