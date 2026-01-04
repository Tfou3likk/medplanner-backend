package com.medplanner.medplanner_backend.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@Transactional(readOnly = true)
	@GetMapping("/patient/{id}")
	public List<RendezVousEntity>listerRdvPatient(@PathVariable Integer id) {
		return rdvRepository.findByIdPatient(id);
	}
	
	@Transactional
	@DeleteMapping("/patient/delete/{id}")
	public List<RendezVousEntity> delete(@PathVariable Integer id) {
		Integer idrecu =  id;
        rdvRepository.deleteById(id);
        List<RendezVousEntity> listeRdvPatient = listerRdvPatient(id);
        return listeRdvPatient;
    }
	
	@GetMapping("/search")
    public List<RendezVousEntity> search(@RequestParam Integer idPatient, @RequestParam@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate date,@RequestParam(required = false) Integer idMedecin,@RequestParam(required = false) Integer idVille,@RequestParam(required = false) Integer idSpecialite) {
        return rdvRepository.recherche(idPatient, date, idMedecin, idVille, idSpecialite);
    }

}
