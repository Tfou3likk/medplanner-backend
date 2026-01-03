package com.medplanner.medplanner_backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.medplanner.medplanner_backend.entities.RendezVousEntity;
import com.medplanner.medplanner_backend.repository.RendezVousRepository;

@RestController
@RequestMapping("/api/medecins")
public class CrenauController {

	RendezVousRepository rdv;

	public CrenauController(RendezVousRepository rdv) {
		super();
		this.rdv = rdv;
	}
	
	@GetMapping("/{idMedecin}/creneaux")
	public List<RendezVousEntity> crenau(@PathVariable Integer idMedecin, @RequestParam(required = false)boolean dispo) {
		
		return rdv.findByIdMedecinAndDispo(idMedecin, dispo);
	}
}
