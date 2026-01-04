package com.medplanner.medplanner_backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.medplanner.medplanner_backend.DTO.MedecinConnectDTO;

import com.medplanner.medplanner_backend.entities.MedecinEntity;
import com.medplanner.medplanner_backend.repository.MedecinRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;


@Tag(name = "Login Medecin")

@RestController
@RequestMapping("/api/medecins")
public class MedecinConnectionController {

	private MedecinRepository medecin;

	public MedecinConnectionController(MedecinRepository medecinRepository) {
		super();
		this.medecin = medecinRepository;
	}
	
	@Operation(
	        summary = "Connexion d'un medecin",
	        description = "Le patient va pouvoir se connecter avec email et mot de passe"
	    )
	    @ApiResponses({
	        @ApiResponse(responseCode = "200", description = "Connexion réussie"),
	        @ApiResponse(responseCode = "401", description = "Identifiant ou mot de passe invalide")
	    })           
	@Transactional(readOnly = true)  
	@PostMapping("/login")
	public ResponseEntity<MedecinEntity> connect(@RequestBody MedecinConnectDTO mDto){
		
		return medecin.findByEmailAndPassword(mDto.getEmail(), mDto.getPassword()).map(ResponseEntity::ok)
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
		
	}
}
