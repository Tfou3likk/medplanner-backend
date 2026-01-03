package com.medplanner.medplanner_backend.controller;

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
	public PatientEntity connect(@RequestBody PatientConnectDTO pDto) {
		
		return patient.findByEmailAndPassword(pDto.getEmail(), pDto.getPassword()).get();
	}
	
	

}
