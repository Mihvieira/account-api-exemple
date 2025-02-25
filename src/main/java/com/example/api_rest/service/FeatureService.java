package com.example.api_rest.service;

import java.util.List;

import com.example.api_rest.dto.FeatureDTO;

public interface FeatureService {

    FeatureDTO findById(Long id);
    FeatureDTO create(FeatureDTO feature);
    List<FeatureDTO> findAll();
    void delete(Long id);
    FeatureDTO update(FeatureDTO featureToUpdate);

}
