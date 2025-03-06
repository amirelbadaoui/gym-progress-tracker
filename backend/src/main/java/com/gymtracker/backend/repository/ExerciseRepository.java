package com.gymtracker.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gymtracker.backend.entity.Exercise;


public interface ExerciseRepository extends JpaRepository<Exercise, Long>{
	
	/**
     * Finds a Recipe object with the provided name. Spring will generate code
     * to make this happen.  Optional let's us call .orElseThrow() when a client
     * works with the method and the value isn't found in the database.
     * 
     * @param name
     *            Name of the exercise
     * @return Found recipe, null if none.
     */
    Optional<Exercise> findByName(String name);
    
}
