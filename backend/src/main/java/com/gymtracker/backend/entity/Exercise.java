package com.gymtracker.backend.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "exercises")
public class Exercise {
	
	/** The id of the exercise */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
