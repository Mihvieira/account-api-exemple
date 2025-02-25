package com.example.api_rest.dto;

import com.example.api_rest.domain.model.News;

public class NewsDTO {

    private Long id;
    private String icon;
    private String description;


    public NewsDTO() {
    }

    public NewsDTO(String icon, String description) {
        this.icon = icon;
        this.description = description;
    }
    
    public NewsDTO(News news) {
        if (news.getId() != null){
            setId(news.getId());
        }
        setIcon(news.getIcon());
        setDescription(news.getDescription());
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
        NewsDTO other = (NewsDTO) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    

}
