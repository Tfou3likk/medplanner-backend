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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.medplanner.medplanner_backend.DTO.RendezVousDTO;
import com.medplanner.medplanner_backend.entities.RendezVousEntity;
import com.medplanner.medplanner_backend.repository.RendezVousRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Rendez-vous")
@RestController
@RequestMapping("/api/rdv")
public class RdvController {
	
	RendezVousRepository rdvRepository;

	public RdvController(RendezVousRepository rdvRepository) {
		super();
		this.rdvRepository = rdvRepository;
	}
	@Operation(
	        summary = "Liste des rendez-vous d'un patient",
	        description = "On recupere tout les rendez vous associer a un client"
	    )
	    @ApiResponses({
	        @ApiResponse(responseCode = "200", description = "Liste des rendez-vous"),
	        @ApiResponse(responseCode = "400", description = "Paramètres invalides ou date manquante")
	    })
	@Transactional(readOnly = true)
	@GetMapping("/patient/{id}")
	public List<RendezVousEntity>listerRdvPatient(@PathVariable Integer id) {
		return rdvRepository.findByIdPatient(id);
	}
	
	@GetMapping("/patient/edit/{id}")
	public RendezVousEntity editRdvPatient(@PathVariable Integer id) {
		RendezVousEntity rdvPatient = rdvRepository.getById(id); 
        return rdvPatient;
    }
	
	@PutMapping("/patient/modif/{id}")
	public List<RendezVousEntity> modifRdvPatient(@PathVariable Integer id, @RequestBody RendezVousDTO  pDto) {
		
		
		RendezVousEntity rdv = rdvRepository.getById(id) ;
		rdv.setDateRdv(pDto.getDate());
		rdv.setHeure(pDto.getHeure());
			
		rdvRepository.save(rdv);
		Integer idPatient = rdv.getIdPatient();
        List<RendezVousEntity> listeRdvPatient = listerRdvPatient(idPatient);
        return listeRdvPatient;
    }
	
	@Operation(
	        summary = "Supprimer un rdv",
	        description = "Supprime un rdv grace a l'identifiant."
	    )
	    @ApiResponses({
	        @ApiResponse(responseCode = "200", description = "Rdv supprimé"),
	        @ApiResponse(responseCode = "404", description = "Rdv introuvable")
	    })
	@Transactional
	@DeleteMapping("/patient/delete/{id}")
	public List<RendezVousEntity> delete(@PathVariable Integer id) {
		Integer idrecu =  id;
        rdvRepository.deleteById(id);
        List<RendezVousEntity> listeRdvPatient = listerRdvPatient(id);
        return listeRdvPatient;
    }
	
	@Operation(
	        summary = "Recherche de rendez-vous",
	        description = """
	            Recherche des rendez-vous d'un patient à une date donnée.
	            La date est obligatoire.
	            Les filtres médecin, ville et spécialité sont optionnels.
	            """
	    )
	    @ApiResponses({
	        @ApiResponse(responseCode = "200", description = "Liste des rdv correspondant"),
	        @ApiResponse(responseCode = "400", description = "Date manquante")
	    })
	@Transactional(readOnly = true)
	@GetMapping("/search")
    public List<RendezVousEntity> search(@RequestParam Integer idPatient, @RequestParam@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate date,@RequestParam(required = false) Integer idMedecin,@RequestParam(required = false) Integer idVille,@RequestParam(required = false) Integer idSpecialite) {
        return rdvRepository.recherche(idPatient, date, idMedecin, idVille, idSpecialite);
    }

}
