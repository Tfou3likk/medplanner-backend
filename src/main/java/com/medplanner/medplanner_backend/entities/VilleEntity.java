package com.medplanner.medplanner_backend.entities;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "ville")
public class VilleEntity {
	
	@Id
	@Column(name = "id_ville")
	private Integer id;
	
	@Column(name = "nom_ville") 
	private String nomVille;
	
	@JsonIgnore
	@OneToMany(mappedBy = "ville" ,fetch = FetchType.LAZY)
	private List<MedecinEntity> medecin;

	public List<MedecinEntity> getMedecin() {
		return medecin;
	}

	public void setMedecin(List<MedecinEntity> medecin) {
		this.medecin = medecin;
	}

	public VilleEntity() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomVille() {
		return nomVille;
	}

	public void setNomVille(String nomVille) {
		this.nomVille = nomVille;
	}
	
	

}
