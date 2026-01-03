package com.medplanner.medplanner_backend.controller;

import org.springframework.web.bind.annotation.*;

import com.medplanner.medplanner_backend.DTO.PatientConnectDTO;
import com.medplanner.medplanner_backend.DTO.PatientSignupDTO;
import com.medplanner.medplanner_backend.entities.PatientEntity;
import com.medplanner.medplanner_backend.repository.PatientRepository;

@RestController
@RequestMapping("/api/patient")
public class SignupPatientController {
	
	PatientRepository patient;

	public SignupPatientController(PatientRepository patient) {
		super();
		this.patient = patient;
	}
	
	@PostMapping("/signup")
	public PatientEntity signup(@RequestBody PatientSignupDTO pDto) {
		
		PatientEntity p = new PatientEntity();
		p.setEmail(pDto.getEmail());
		p.setNom(pDto.getNom());
		p.setPrenom(pDto.getPrenom());
		p.setPassword(pDto.getPassword());
		if(patient.findByEmail(pDto.getEmail()).isPresent()) {
			return null;
		}
		patient.save(p);
		
		return p;
	}
}
