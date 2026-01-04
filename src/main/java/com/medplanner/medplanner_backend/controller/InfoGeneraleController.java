package com.medplanner.medplanner_backend.controller;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medplanner.medplanner_backend.entities.MedecinEntity;
import com.medplanner.medplanner_backend.entities.SpecialiteEntity;
import com.medplanner.medplanner_backend.entities.VilleEntity;
import com.medplanner.medplanner_backend.repository.MedecinRepository;
import com.medplanner.medplanner_backend.repository.SpecialiteRepository;
import com.medplanner.medplanner_backend.repository.VilleRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Informations générales")
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
    
    @Operation(
            summary = "Lister des médecins",
            description = "Retourne la liste de tous les médecins."
        )
        @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Liste des médecins OK")
        })
    @Transactional(readOnly = true)
    @GetMapping("/medecins")
    public List<MedecinEntity> medecins() {
        return medecinRepository.findAll();
    }

    @Operation(
            summary = "Lister des villes",
            description = "Retourne la liste de toutes les villes."
        )
        @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Liste des villes OK")
        })
    @Transactional(readOnly = true)
    @GetMapping("/villes")
    public List<VilleEntity> villes() {
        return villeRepository.findAll();
    }
    

    @Operation(
            summary = "Lister des Specialite",
            description = "Retourne la liste de toutes les specialites."
        )
        @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Liste des Specialite OK")
        })
    @Transactional(readOnly = true)
    @GetMapping("/specialites")
    public List<SpecialiteEntity> specialites() {
        return specialiteRepository.findAll();
    }
    
    
}
