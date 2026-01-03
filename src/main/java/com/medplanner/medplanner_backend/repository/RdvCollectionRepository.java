package com.medplanner.medplanner_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medplanner.medplanner_backend.entities.RdvCollectionEntity;

public interface RdvCollectionRepository extends JpaRepository<RdvCollectionEntity, Integer> {

}
