package com.medplanner.medplanner_backend.repository.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.medplanner.medplanner_backend.entities.MedecinEntity;
import com.medplanner.medplanner_backend.entities.PatientEntity;
import com.medplanner.medplanner_backend.entities.RendezVousEntity;
import com.medplanner.medplanner_backend.entities.SpecialiteEntity;
import com.medplanner.medplanner_backend.entities.VilleEntity;
import com.medplanner.medplanner_backend.repository.RendezVousRepositoryCustom;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Repository
public class RendezVousRepositoryImpl implements RendezVousRepositoryCustom {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<RendezVousEntity> recherche(Integer idPatient, LocalDate date, Integer idMedecin, Integer idVille,
			Integer idSpecialite) {
		
		CriteriaQuery<RendezVousEntity> cq = em.getCriteriaBuilder().createQuery(RendezVousEntity.class);
		
		Root<RendezVousEntity> rdv = cq.from(RendezVousEntity.class);
		
		Join<RendezVousEntity, MedecinEntity> jointureRdvMedecin = rdv.join("medecin", JoinType.INNER);
		
		Join<MedecinEntity, VilleEntity> jointureMedecinVille = jointureRdvMedecin.join("ville", JoinType.INNER);
		
		Join<MedecinEntity, SpecialiteEntity> jointureMedecinSpecialite = jointureRdvMedecin.join("specialite", JoinType.INNER);
		
		Join<RendezVousEntity, PatientEntity> jointureRdvPatient = rdv.join("patient", JoinType.INNER);
		
		List<Predicate> predicates = new ArrayList<>();
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		predicates.add(cb.equal(jointureRdvPatient.get("id"), idPatient));
		predicates.add(cb.equal(rdv.get("dateRdv"), date));
		
		if(idMedecin !=null) {
			predicates.add(cb.equal(jointureRdvMedecin.get("id"), idMedecin));
		}
		
		if(idVille !=null) {
			predicates.add(cb.equal(jointureMedecinVille.get("id"), idVille ));
		}
		if(idSpecialite !=null) {
			predicates.add(cb.equal(jointureMedecinSpecialite.get("id"), idSpecialite));
		}
		
		cq.select(rdv).where(predicates.toArray(new Predicate[0])).orderBy(  cb.asc(rdv.get("dateRdv")), cb.asc(rdv.get("heure")));
		
		return em.createQuery(cq).getResultList();
	}
	
	

}
