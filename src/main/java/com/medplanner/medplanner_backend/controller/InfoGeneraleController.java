package com.medplanner.medplanner_backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medplanner.medplanner_backend.entities.MedecinEntity;
import com.medplanner.medplanner_backend.entities.SpecialiteEntity;
import com.medplanner.medplanner_backend.entities.VilleEntity;
import com.medplanner.medplanner_backend.repository.MedecinRepository;
import com.medplanner.medplanner_backend.repository.SpecialiteRepository;
import com.medplanner.medplanner_backend.repository.VilleRepository;

@RestController
@RequestMapping("/api/info")
public class InfoGeneraleController {

	private  MedecinRepository medecinRepository;
    private VilleRepository villeRepository;
    private SpecialiteRepository specialiteRepository;
	
    public InfoGeneraleController(MedecinRepository medecinRepository, VilleRepository villeRepository,
			SpecialiteRepository specialiteRepository) {
		super();
		this.medecinRepository = medecinRepository;
		this.villeRepository = villeRepository;
		this.specialiteRepository = specialiteRepository;
	}
    
    @GetMapping("/medecins")
    public List<MedecinEntity> medecins() {
        return medecinRepository.findAll();
    }

    @GetMapping("/villes")
    public List<VilleEntity> villes() {
        return villeRepository.findAll();
    }

    @GetMapping("/specialites")
    public List<SpecialiteEntity> specialites() {
        return specialiteRepository.findAll();
    }
    
    
}
