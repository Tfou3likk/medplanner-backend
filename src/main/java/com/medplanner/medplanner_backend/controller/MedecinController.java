package com.medplanner.medplanner_backend.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;

import com.medplanner.medplanner_backend.entities.MedecinEntity;
import com.medplanner.medplanner_backend.repository.MedecinRepository;

@RestController
@RequestMapping("/api/medecins")
//Classe de test JSon Swagger  l'init du projet
public class MedecinController {
	
	private MedecinRepository medecinRepository;

	public MedecinController(MedecinRepository medecinRepository) {
		super();
		this.medecinRepository = medecinRepository;
	}
	
	@Transactional(readOnly = true)
	@GetMapping
    public List<MedecinEntity> getAll() {
        return medecinRepository.findAll();
    }

	@Transactional(readOnly = true)
    @GetMapping("/{id}")
    public MedecinEntity getById(@PathVariable Integer id) {
        return medecinRepository.findById(id).orElse(null);
    }

	@Transactional
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MedecinEntity create(@RequestBody MedecinEntity medecin) {
        medecin.setId(null);
        return medecinRepository.save(medecin);
    }

  
	@Transactional
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        medecinRepository.deleteById(id);
    }
	
}
