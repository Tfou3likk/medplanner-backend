package com.medplanner.medplanner_backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "etablissement")
public class EtablissementEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_etablissement")
	private Integer id;
	
	@Column
	private String lieu;
	
	

	public EtablissementEntity() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	
	
	
}
