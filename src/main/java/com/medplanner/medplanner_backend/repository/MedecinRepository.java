package com.medplanner.medplanner_backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medplanner.medplanner_backend.entities.MedecinEntity;
import com.medplanner.medplanner_backend.entities.PatientEntity;

public interface MedecinRepository extends JpaRepository<MedecinEntity, Integer>{

	Optional<MedecinEntity> findByEmailAndPassword(String email, String password);
}
