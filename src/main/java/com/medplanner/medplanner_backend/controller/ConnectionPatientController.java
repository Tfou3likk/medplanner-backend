package com.medplanner.medplanner_backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.medplanner.medplanner_backend.DTO.PatientConnectDTO;
import com.medplanner.medplanner_backend.entities.PatientEntity;
import com.medplanner.medplanner_backend.repository.PatientRepository;



@RestController
@RequestMapping("/api/patient")
public class ConnectionPatientController {
	
	private PatientRepository patient;

	public ConnectionPatientController(PatientRepository patient) {
		super();
		this.patient = patient;
	}
	
	            
	    
	@PostMapping("/login")
	public ResponseEntity<PatientEntity> connect(@RequestBody PatientConnectDTO pDto) {
		
		return patient.findByEmailAndPassword(pDto.getEmail(), pDto.getPassword()).map(ResponseEntity::ok)
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	
	

}
