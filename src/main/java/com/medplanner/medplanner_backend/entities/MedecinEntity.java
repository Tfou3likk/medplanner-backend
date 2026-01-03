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
	
	@Column(name = "id_etablissement")
	private Integer idEtablissement;
	
	@Column(name = "id_specialite")
	private Integer idSpecialite;
	
	@Column(name = "duree_rdv")
	private Integer dureeRdv;
	
	
	@Column(name = "heure_embauche")
	private LocalTime heureEmbauche;
	
	//@Many
	//private EtablissementEntity etablissement;
	
	public MedecinEntity() {
		super();
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

	public Integer getIdEtablissement() {
		return idEtablissement;
	}

	public void setIdEtablissement(Integer idEtablissement) {
		this.idEtablissement = idEtablissement;
	}

	public Integer getIdSpecialite() {
		return idSpecialite;
	}

	public void setIdSpecialite(Integer idSpecialite) {
		this.idSpecialite = idSpecialite;
	}

	public Integer getDureeRdv() {
		return dureeRdv;
	}

	public void setDureeRdv(Integer dureeRdv) {
		this.dureeRdv = dureeRdv;
	}

	public LocalTime getHeureEmbauche() {
		return heureEmbauche;
	}

	public void setHeureEmbauche(LocalTime heureEmbauche) {
		this.heureEmbauche = heureEmbauche;
	}

	
	
	

}
