package com.medplanner.medplanner_backend.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.*;

@Entity
@Table(name = "rendez_vous")
public class RendezVousEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rdv")
    private Integer id;
	
	@Column(name = "id_medecin")
	private Integer idMedecin;

    @Column(name = "date_rdv")
    private LocalDate dateRdv;

    @Column
    private LocalTime heure;

    @Column(name = "compte_rendu")
    private String compteRendu;
    
    @Column
    private boolean dispo;
    
    

	public RendezVousEntity() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdMedecin() {
		return idMedecin;
	}

	public void setIdMedecin(Integer idMedecin) {
		this.idMedecin = idMedecin;
	}

	public LocalDate getDateRdv() {
		return dateRdv;
	}

	public void setDateRdv(LocalDate dateRdv) {
		this.dateRdv = dateRdv;
	}

	public LocalTime getHeure() {
		return heure;
	}

	public void setHeure(LocalTime heure) {
		this.heure = heure;
	}

	public String getCompteRendu() {
		return compteRendu;
	}

	public void setCompteRendu(String compteRendu) {
		this.compteRendu = compteRendu;
	}

	public boolean isDispo() {
		return dispo;
	}

	public void setDispo(boolean dispo) {
		this.dispo = dispo;
	}
    
    

}
