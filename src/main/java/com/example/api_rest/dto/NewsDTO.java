package com.example.api_rest.dto;

import com.example.api_rest.domain.model.News;

import lombok.Data;

@Data
public class NewsDTO {

    private Long id;
    private String icon;
    private String description;


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

}
