package com.medplanner.medplanner_backend.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "specialite")
public class SpecialiteEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_specialite")
	private Integer id;
	
	@Column(name = "libelle_specialite")
	private String libelle;
	
	@JsonIgnore
	@OneToMany(mappedBy = "specialite" ,fetch = FetchType.LAZY)
	private List<MedecinEntity> medecin;

	public List<MedecinEntity> getMedecin() {
		return medecin;
	}

	public void setMedecin(List<MedecinEntity> medecin) {
		this.medecin = medecin;
	}

	public SpecialiteEntity() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	

}
