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

import com.medplanner.medplanner_backend.entities.MedecinEntity;
import com.medplanner.medplanner_backend.repository.MedecinRepository;

@RestController
@RequestMapping("/api/medecins")
public class MedecinController {
	
	private MedecinRepository medecinRepository;

	public MedecinController(MedecinRepository medecinRepository) {
		super();
		this.medecinRepository = medecinRepository;
	}
	
	@GetMapping
    public List<MedecinEntity> getAll() {
        return medecinRepository.findAll();
    }

    
    @GetMapping("/{id}")
    public MedecinEntity getById(@PathVariable Integer id) {
        return medecinRepository.findById(id).orElse(null);
    }

   
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MedecinEntity create(@RequestBody MedecinEntity medecin) {
        medecin.setId(null);
        return medecinRepository.save(medecin);
    }

  
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        medecinRepository.deleteById(id);
    }
	
}
