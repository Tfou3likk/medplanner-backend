package com.medplanner.medplanner_backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<PatientEntity> signup(@RequestBody PatientSignupDTO pDto) {
		
		if(patient.findByEmail(pDto.getEmail()).isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
		
		PatientEntity p = new PatientEntity();
		p.setEmail(pDto.getEmail());
        p.setNom(pDto.getNom());
        p.setPrenom(pDto.getPrenom());
        p.setPassword(pDto.getPassword());
        p.setDateNaissance(pDto.getDateNaissance());
        
        
        
        return ResponseEntity.status(HttpStatus.CREATED).body(patient.save(p));
	}
}
