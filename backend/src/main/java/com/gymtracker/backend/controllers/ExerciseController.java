package com.gymtracker.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gymtracker.backend.dto.ExerciseDto;
import com.gymtracker.backend.services.ExerciseService;

/**
 * Controller for Exercises.
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/api/exercises")
public class ExerciseController {

	/** Connection to ExerciseService */
	@Autowired
	private ExerciseService ExerciseService;
	
	
	
	/**
     * REST API method to provide GET access to all exercises in the system
     *
     * @return JSON representation of all exercises
     */
    @GetMapping
    public List<ExerciseDto> getExercises () {
        return ExerciseService.getAllExercises();
    }
    
    /**
     * REST API method to provide GET access to a specific Exercise, as indicated
     * by the path variable provided (the name of the Exercise desired)
     *
     * @param name
     *            Exercise name
     * @return response to the request
     */
    @GetMapping("{name}")
    public ResponseEntity<ExerciseDto> getExercise ( @PathVariable("name") String name ) {
        ExerciseDto ExerciseDto = ExerciseService.getExerciseByName(name);
        return ResponseEntity.ok(ExerciseDto);
    }
    
    /**
     * REST API method to provide POST access to the Exercise model. 
     *
     * @param ExerciseDto
     *            The valid Exercise to be saved.
     * @return ResponseEntity indicating success if the Exercise could be saved to
     *         the inventory, or an error if it could not be
     */
    @PostMapping
    public ResponseEntity<ExerciseDto> createExercise(@RequestBody ExerciseDto ExerciseDto) {
    	if (ExerciseService.isDuplicateName(ExerciseDto.getName())) {
    		return new ResponseEntity<>(ExerciseDto, HttpStatus.CONFLICT);
    	}
    	
    	if(ExerciseDto.getPrice() < 0) {
    		return new ResponseEntity<>(ExerciseDto, HttpStatus.BAD_REQUEST);
    	}
    	
    	if(ExerciseDto.getIngredients().size() == 0) {
    		return new ResponseEntity<>(ExerciseDto, HttpStatus.BAD_REQUEST);
    	}
    	
    	List<Ingredient> ingredients = ExerciseDto.getIngredients();
    	
    	for(Ingredient i : ingredients) {
    		if(i.getAmount() < 0) {
    			return new ResponseEntity<>(ExerciseDto, HttpStatus.BAD_REQUEST);
    		}
    	}
    	
    	if (ExerciseService.getAllExercises().size() < 3) {
    		ExerciseDto savedExerciseDto = ExerciseService.createExercise(ExerciseDto);
    		return ResponseEntity.ok(savedExerciseDto);
    	} else {
    		return new ResponseEntity<>(ExerciseDto, HttpStatus.INSUFFICIENT_STORAGE);
    	}
    }
    
    /**
     * REST API method to allow deleting a Exercise from the CoffeeMaker's
     * Inventory, by making a DELETE request to the API endpoint and indicating
     * the Exercise to delete (as a path variable)
     *
     * @param id
     *            The id of the Exercise to delete
     * @return Success if the Exercise could be deleted; an error if the Exercise
     *         does not exist
     */
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteExercise(@PathVariable("id") Long ExerciseId) {
    	ExerciseService.deleteExercise(ExerciseId);
    	return ResponseEntity.ok("Exercise deleted successfully.");
    }
    

    /**
     * REST API method to allow updating a Exercise from the CoffeeMaker's
     * Inventory, by making a PUT request to the API endpoint and indicating
     * the Exercise to update
     *
     * @param name
     *            The jd of the Exercise to update
     * @param ExerciseDto
            The data transfer of the Exercise to update
     * @return Success if the Exercise could be deleted; an error if the Exercise
     *         does not exist
     */
    @PutMapping("{ExerciseId}")
    public ResponseEntity<ExerciseDto> updateExercise(@PathVariable("ExerciseId") Long ExerciseId, @RequestBody ExerciseDto ExerciseDto) {
    	if(ExerciseDto.getPrice() < 0) {
    		return new ResponseEntity<>(ExerciseDto, HttpStatus.BAD_REQUEST);
    	}
    	
    	if(ExerciseDto.getIngredients().size() == 0) {
    		return new ResponseEntity<>(ExerciseDto, HttpStatus.BAD_REQUEST);
    	}
    	
    	List<String> targetedMuscles = ExerciseDto.getTargetedMuscles();
    	

    	
    	
    	ExerciseDto savedExercise = ExerciseService.updateExercise(ExerciseId, ExerciseDto);
    	
    	
    	return ResponseEntity.ok(savedExercise);
    }
    
    
}