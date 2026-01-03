package com.medplanner.medplanner_backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medplanner.medplanner_backend.entities.PatientEntity;

public interface PatientRepository extends JpaRepository<PatientEntity, Integer> {
	
	Optional<PatientEntity> findByEmailAndPassword(String email, String password);
	
	Optional<PatientEntity> findByEmail(String email);
}
