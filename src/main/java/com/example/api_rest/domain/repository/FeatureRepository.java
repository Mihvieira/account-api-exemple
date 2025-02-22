package com.example.api_rest.domain.repository;

import com.example.api_rest.domain.model.Feature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeatureRepository extends JpaRepository<Feature, Long> {
}
