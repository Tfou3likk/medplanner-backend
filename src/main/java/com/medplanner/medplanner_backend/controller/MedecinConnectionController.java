package com.medplanner.medplanner_backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.medplanner.medplanner_backend.DTO.MedecinConnectDTO;

import com.medplanner.medplanner_backend.entities.MedecinEntity;
import com.medplanner.medplanner_backend.repository.MedecinRepository;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/medecins")
public class MedecinConnectionController {

	private MedecinRepository medecin;

	public MedecinConnectionController(MedecinRepository medecinRepository) {
		super();
		this.medecin = medecinRepository;
	}
	
	@PostMapping("/login")
	public ResponseEntity<MedecinEntity> connect(@RequestBody MedecinConnectDTO mDto){
		
		return medecin.findByEmailAndPassword(mDto.getEmail(), mDto.getPassword()).map(ResponseEntity::ok)
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
		
	}
}
