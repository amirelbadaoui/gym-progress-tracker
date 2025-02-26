package com.gymtracker.backend.services;

import java.util.List;

import com.gymtracker.backend.dto.ExerciseDto;

public interface ExerciseService {
	ExerciseDto createExercise(ExerciseDto ingredientDto);
	
	ExerciseDto getExerciseById(Long ingredientId);
	
	List<ExerciseDto> getAllExercises();
	
	void deleteExercise(Long ingredientId);
	
	void deleteAllExercises();
}
