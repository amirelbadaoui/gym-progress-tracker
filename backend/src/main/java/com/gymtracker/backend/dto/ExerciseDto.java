package com.gymtracker.backend.dto;

import java.util.List;


public class ExerciseDto {
	
	/** The id of the exercise */
	private Long id;
	
	/** The name of the exercise */
	private String name;
	
	/** The targeted muscles */
	private List<String> targetedMuscles;
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the targetedMuscles
	 */
	public List<String> getTargetedMuscles() {
		return targetedMuscles;
	}

	/**
	 * @param targetedMuscles the targetedMuscles to set
	 */
	public void setTargetedMuscles(List<String> targetedMuscles) {
		this.targetedMuscles = targetedMuscles;
	}
	
	
}

