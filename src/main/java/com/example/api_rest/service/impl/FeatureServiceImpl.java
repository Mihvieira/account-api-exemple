package com.example.api_rest.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.api_rest.domain.model.Feature;
import com.example.api_rest.domain.repository.FeatureRepository;
import com.example.api_rest.dto.FeatureDTO;
import com.example.api_rest.service.FeatureService;

import jakarta.transaction.Transactional;

@Service
public class FeatureServiceImpl implements FeatureService{

    private final FeatureRepository featureRepository;

    public FeatureServiceImpl(FeatureRepository featureRepository) {
        this.featureRepository = featureRepository;
    }

    @Override
    public FeatureDTO findById(Long id) {
        var feature = featureRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return new FeatureDTO(feature);
    }

    @Override
    @Transactional
    public FeatureDTO create(FeatureDTO featureToCreate) {
        try {
            Feature feature = new Feature();
            if (featureToCreate.getId() != null) {
                    feature.setId(featureToCreate.getId());
                }
                feature.setIcon(featureToCreate.getIcon());
                feature.setDescription(featureToCreate.getDescription());
                Feature savedfeature = featureRepository.save(feature);
                return new FeatureDTO(savedfeature);
        } catch (Exception e) {
            throw new RuntimeException("Unexpected error: " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
        featureRepository.deleteById(id);
    }

    @Override
    public FeatureDTO update(FeatureDTO featureToUpdate) {
        if (featureToUpdate.getId() != null) {
            return create(featureToUpdate);
        }else{
            throw new IllegalArgumentException("Id must not be null");
        } 
    }

    @Override
    public List<FeatureDTO> findAll() {
        List<Feature> features = featureRepository.findAll();
        return features.stream().map(FeatureDTO::new).collect(Collectors.toList());
    }

}
