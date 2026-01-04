package com.medplanner.medplanner_backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.medplanner.medplanner_backend.DTO.PatientConnectDTO;
import com.medplanner.medplanner_backend.DTO.PatientSignupDTO;
import com.medplanner.medplanner_backend.entities.PatientEntity;
import com.medplanner.medplanner_backend.repository.PatientRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Authentification Patient")
@RestController
@RequestMapping("/api/patient")
public class SignupPatientController {
	
	PatientRepository patient;

	public SignupPatientController(PatientRepository patient) {
		super();
		this.patient = patient;
	}
	@Operation(
	        summary = "Inscription d'un patient",
	        description = "Le patient va inscrire un email, un nom, un prenom, uen date de naissance et un mot de passe"
	    )
	    @ApiResponses({
	        @ApiResponse(responseCode = "201", description = "Patient crée"),
	        @ApiResponse(responseCode = "409", description = "Email existant")
	    })        
	@Transactional
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
