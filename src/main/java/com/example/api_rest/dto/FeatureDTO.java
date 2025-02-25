package com.example.api_rest.dto;

import com.example.api_rest.domain.model.Feature;

public class FeatureDTO {

    private Long id;
    private String icon;
    private String description;

    public FeatureDTO() {
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        FeatureDTO other = (FeatureDTO) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    

}
