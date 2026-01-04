package com.medplanner.medplanner_backend.repository;

import java.time.LocalDate;
import java.util.List;

import com.medplanner.medplanner_backend.entities.RendezVousEntity;

public interface RendezVousRepositoryCustom {

	List<RendezVousEntity> recherche(Integer idPatient, LocalDate date, Integer medecinId, Integer villeId, Integer specialiteId);
}
