package com.medplanner.medplanner_backend.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

public class RendezVousDTO {

	private Integer idPatient;
	
	private Integer idRdv;
	
	private LocalDate date;
	
	private LocalTime heure;
	
	

	public RendezVousDTO() {
		super();
	}


	public RendezVousDTO(Integer idPatient, Integer idRdv, LocalDate date, LocalTime heure) {
		super();
		this.idPatient = idPatient;
		this.idRdv = idRdv;
		this.date = date;
		this.heure = heure;
	}


	public RendezVousDTO(Integer idPatient, Integer idRdv) {
		super();
		this.idPatient = idPatient;
		this.idRdv = idRdv;
	}

	
	public RendezVousDTO(LocalDate date, LocalTime heure) {
		super();
		this.date = date;
		this.heure = heure;
	}

	public Integer getIdPatient() {
		return idPatient;
	}



	public void setIdPatient(Integer idPatient) {
		this.idPatient = idPatient;
	}



	public Integer getIdRdv() {
		return idRdv;
	}

	public void setIdRdv(Integer idRdv) {
		this.idRdv = idRdv;
	}



	public LocalDate getDate() {
		return date;
	}



	public void setDate(LocalDate date) {
		this.date = date;
	}



	public LocalTime getHeure() {
		return heure;
	}



	public void setHeure(LocalTime heure) {
		this.heure = heure;
	}
	
	
}
