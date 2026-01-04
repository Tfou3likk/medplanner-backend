package com.medplanner.medplanner_backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.medplanner.medplanner_backend.DTO.PatientConnectDTO;
import com.medplanner.medplanner_backend.entities.PatientEntity;
import com.medplanner.medplanner_backend.repository.PatientRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "Login Patient")
@RestController
@RequestMapping("/api/patient")
public class ConnectionPatientController {
	
	private PatientRepository patient;

	public ConnectionPatientController(PatientRepository patient) {
		super();
		this.patient = patient;
	}
	
	@Operation(
	        summary = "Connexion d'un patient",
	        description = "Le patient va pouvoir se connecter avec email et mot de passe"
	    )
	    @ApiResponses({
	        @ApiResponse(responseCode = "200", description = "Connexion réussie"),
	        @ApiResponse(responseCode = "401", description = "Identifiant ou mot de passe invalide")
	    })           
	@Transactional(readOnly = true)  
	@PostMapping("/login")
	public ResponseEntity<PatientEntity> connect(@RequestBody PatientConnectDTO pDto) {
		
		return patient.findByEmailAndPassword(pDto.getEmail(), pDto.getPassword()).map(ResponseEntity::ok)
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	
	

}
