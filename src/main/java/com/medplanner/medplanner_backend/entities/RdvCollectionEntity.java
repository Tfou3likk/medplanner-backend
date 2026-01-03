package com.medplanner.medplanner_backend.entities;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "rdv_collection_patient")
public class RdvCollectionEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_rdv")
    private Integer idRdv;

    @Column(name = "id_patient")
    private Integer idPatient;

    @Column(name = "date_reservation")
    private LocalDateTime dateReservation;

    @Column
    private String statut;

	public RdvCollectionEntity() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdRdv() {
		return idRdv;
	}

	public void setIdRdv(Integer idRdv) {
		this.idRdv = idRdv;
	}

	public Integer getIdPatient() {
		return idPatient;
	}

	public void setIdPatient(Integer idPatient) {
		this.idPatient = idPatient;
	}

	public LocalDateTime getDateReservation() {
		return dateReservation;
	}

	public void setDateReservation(LocalDateTime dateReservation) {
		this.dateReservation = dateReservation;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}
    
    

}
