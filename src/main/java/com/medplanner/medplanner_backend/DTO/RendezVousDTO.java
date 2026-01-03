package com.medplanner.medplanner_backend.DTO;

import org.springframework.web.bind.annotation.*;

import com.medplanner.medplanner_backend.repository.RendezVousRepository;

public class RendezVousDTO {

	private Integer idPatient;
	
	private Integer idRdv;

	public RendezVousDTO(Integer idPatient, Integer idRdv) {
		super();
		this.idPatient = idPatient;
		this.idRdv = idRdv;
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
	
	
	
	
}
