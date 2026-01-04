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
	
	@Column(name = "id_patient", insertable=false, updatable=false)
	private Integer idPatient;
	
	@Column(name = "id_medecin",insertable=false, updatable=false)
	private Integer idMedecin;

    @Column(name = "date_rdv")
    private LocalDate dateRdv;

    @Column(name = "heure_rdv")
    private LocalTime heure;

    @Column(name = "compte_rendu_rdv")
    private String compteRenduRdv;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_patient")
    private PatientEntity patient;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_medecin")
    private MedecinEntity medecin;
    
    
    

	public RendezVousEntity() {
		super();
	}
	
	public RendezVousEntity(Integer id, LocalDate dateRdv, LocalTime heure) {
		super();
		this.id = id;
		this.dateRdv = dateRdv;
		this.heure = heure;
	}	

	public Integer getIdPatient() {
		return idPatient;
	}



	public void setIdPatient(Integer idPatient) {
		this.idPatient = idPatient;
	}



	public String getCompteRenduRdv() {
		return compteRenduRdv;
	}



	public void setCompteRenduRdv(String compteRenduRdv) {
		this.compteRenduRdv = compteRenduRdv;
	}



	public PatientEntity getPatient() {
		return patient;
	}



	public void setPatient(PatientEntity patient) {
		this.patient = patient;
	}



	public MedecinEntity getMedecin() {
		return medecin;
	}



	public void setMedecin(MedecinEntity medecin) {
		this.medecin = medecin;
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


    
    

}
