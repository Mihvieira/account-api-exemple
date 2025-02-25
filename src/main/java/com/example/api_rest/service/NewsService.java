package com.example.api_rest.service;

import java.util.List;

import com.example.api_rest.dto.NewsDTO;

public interface NewsService {

    NewsDTO findById(Long id);
    NewsDTO create(NewsDTO news);
    List<NewsDTO> findAll();
    void delete(Long id);
    NewsDTO update(NewsDTO newsToUpdate);

}
