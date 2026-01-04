package com.medplanner.medplanner_backend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medplanner.medplanner_backend.entities.RendezVousEntity;
import com.medplanner.medplanner_backend.repository.RendezVousRepository;

@RestController
@RequestMapping("/api/rdv")
public class RdvController {
	
	RendezVousRepository rdvRepository;

	public RdvController(RendezVousRepository rdvRepository) {
		super();
		this.rdvRepository = rdvRepository;
	}
	
	@GetMapping("/patient/{id}")
	public List<RendezVousEntity>listerRdvPatient(@PathVariable Integer id) {
		return rdvRepository.findByIdPatient(id);
	}
	
	@DeleteMapping("/patient/{id}")
	public void delete(@PathVariable Integer id) {
        rdvRepository.deleteById(id);
    }

}
