package com.medplanner.medplanner_backend.entities;


import java.time.LocalTime;

import jakarta.persistence.*;

@Entity
@Table(name = "medecin")
public class MedecinEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_medecin" )
	private Integer id;
	
	@Column
	private String nom;
	
	@Column
	private String prenom;
	
	@Column
	private String password;
	
	@Column
	private String email;
	
	@Column(name = "id_specialite", insertable=false, updatable=false)
	private Integer idSpecialite;
	
	@Column(name = "id_ville", insertable=false, updatable=false)
	private Integer idVille;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "id_ville")
	private VilleEntity ville;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "id_specialite")
	private SpecialiteEntity specialite;
	
	
	public Integer getIdVille() {
		return idVille;
	}



	public void setIdVille(Integer idVille) {
		this.idVille = idVille;
	}



	public VilleEntity getVille() {
		return ville;
	}



	public void setVille(VilleEntity ville) {
		this.ville = ville;
	}



	public SpecialiteEntity getSpecialite() {
		return specialite;
	}



	public void setSpecialite(SpecialiteEntity specialite) {
		this.specialite = specialite;
	}



	public MedecinEntity() {
		super();
	}
	
	

	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public Integer getIdSpecialite() {
		return idSpecialite;
	}

	public void setIdSpecialite(Integer idSpecialite) {
		this.idSpecialite = idSpecialite;
	}

	
	

	
	
	

}
