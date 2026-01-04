package com.medplanner.medplanner_backend.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medplanner.medplanner_backend.entities.RendezVousEntity;

public interface RendezVousRepository extends JpaRepository<RendezVousEntity, Integer>,RendezVousRepositoryCustom {
	

	List<RendezVousEntity> findByIdPatient(Integer IdPatient);
	
	void deleteById (Integer idRv);
}
