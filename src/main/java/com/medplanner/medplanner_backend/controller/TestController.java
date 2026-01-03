package com.medplanner.medplanner_backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medplanner.medplanner_backend.entities.MedecinEntity;
import com.medplanner.medplanner_backend.entities.PatientEntity;
import com.medplanner.medplanner_backend.repository.PatientRepository;

@RestController

public class TestController {
	
	PatientRepository patient;
	
	public TestController(PatientRepository patient) {
		super();
		this.patient = patient;
	}

	@GetMapping("/test")
	public String test() {
		
		return "bon courage";
	}
	
	@GetMapping("/patient")
    public List<PatientEntity> getAll() {
		List<PatientEntity> liste = this.patient.findAll();
        return liste;
    }
	
}
