package com.example.api_rest.dto;

import com.example.api_rest.domain.model.Feature;

import lombok.Data;

@Data
public class FeatureDTO {

    private Long id;
    private String icon;
    private String description;


    public FeatureDTO(String icon, String description) {
        this.icon = icon;
        this.description = description;
    }


    public FeatureDTO(Feature feature) {
        if (feature.getId() != null){
            setId(feature.getId());
        }
        setIcon(feature.getIcon());
        setDescription(feature.getDescription());
    }

}
