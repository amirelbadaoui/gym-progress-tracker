package com.gymtracker.backend.services;

import java.util.List;

import com.gymtracker.backend.dto.ExerciseDto;

public interface ExerciseService {
	ExerciseDto createExercise(ExerciseDto exerciseDto);
	
	ExerciseDto getExerciseByName(String exerciseName);
	
	List<ExerciseDto> getAllExercises();
	
	void deleteExercise(Long exerciseId);
	
	void deleteAllExercises();
}
