package com.medplanner.medplanner_backend.controller;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.*;

import com.medplanner.medplanner_backend.DTO.PatientSignupDTO;
import com.medplanner.medplanner_backend.DTO.RendezVousDTO;
import com.medplanner.medplanner_backend.entities.RdvCollectionEntity;
import com.medplanner.medplanner_backend.entities.RendezVousEntity;
import com.medplanner.medplanner_backend.repository.RdvCollectionRepository;
import com.medplanner.medplanner_backend.repository.RendezVousRepository;

@RestController
@RequestMapping("/api/patient")
public class RdvController {
	
	RendezVousRepository rdvRepository;
	RdvCollectionRepository rdvCollection;
	
	
	
	public RdvController(RendezVousRepository rdvRepository, RdvCollectionRepository rdvCollection) {
		super();
		this.rdvRepository = rdvRepository;
		this.rdvCollection = rdvCollection;
	}



	@PostMapping("/rdv")
	public RdvCollectionEntity reserver(@RequestBody RendezVousDTO rdvDto) {
		
		RendezVousEntity rdv = rdvRepository.findById(rdvDto.getIdRdv()).orElse(null);
		 if (rdv == null) {
			 return null;
		 }
		
		if(!rdv.isDispo()) {
			return null;
		}
		rdv.setDispo(false);
		rdvRepository.save(rdv);
		
		RdvCollectionEntity rCollection = new RdvCollectionEntity();
		rCollection.setIdRdv(rdvDto.getIdRdv());
		rCollection.setIdPatient(rdvDto.getIdPatient());
		rCollection.setDateReservation(LocalDateTime.now());
		rCollection.setStatut("RESERVE");
		
		return rdvCollection.save(rCollection);
		
	}
}
