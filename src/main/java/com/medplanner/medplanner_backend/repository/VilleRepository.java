package com.medplanner.medplanner_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medplanner.medplanner_backend.entities.SpecialiteEntity;
import com.medplanner.medplanner_backend.entities.VilleEntity;

public interface VilleRepository extends JpaRepository<VilleEntity, Integer> {

}
