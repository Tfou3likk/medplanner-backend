package com.medplanner.medplanner_backend.entities;


import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "ville")
public class VilleEntity {
	
	@Id
	@Column(name = "id_ville")
	private Integer id;
	
	@Column(name = "nom_ville") 
	private String nomVille;
	
	@OneToMany(mappedBy = "ville" ,fetch = FetchType.LAZY)
	private List<MedecinEntity> medecin;

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
