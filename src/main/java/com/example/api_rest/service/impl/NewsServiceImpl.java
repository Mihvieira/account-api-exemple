package com.example.api_rest.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.api_rest.domain.model.News;
import com.example.api_rest.domain.repository.NewsRepository;
import com.example.api_rest.dto.NewsDTO;
import com.example.api_rest.service.NewsService;

import jakarta.transaction.Transactional;

@Service
public class NewsServiceImpl implements NewsService{

    private final NewsRepository newsRepository;

    public NewsServiceImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public NewsDTO findById(Long id) {
        var news = newsRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return new NewsDTO(news);
    }

    @Override
    @Transactional
    public NewsDTO create(NewsDTO newsToCreate) {
        try {
            News news = new News();
            if (newsToCreate.getId() != null) {
                    news.setId(newsToCreate.getId());
                }
                news.setIcon(newsToCreate.getIcon());
                news.setDescription(newsToCreate.getDescription());
                News savedNews = newsRepository.save(news);
                return new NewsDTO(savedNews);
        } catch (Exception e) {
            throw new RuntimeException("Unexpected error: " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
        newsRepository.deleteById(id);
    }

    @Override
    public NewsDTO update(NewsDTO newsToUpdate) {
        if (newsToUpdate.getId() != null) {
            return create(newsToUpdate);
        }else{
            throw new IllegalArgumentException("Id must not be null");
        } 
    }

    @Override
    public List<NewsDTO> findAll() {
        List<News> news = newsRepository.findAll();
        return news.stream().map(NewsDTO::new).collect(Collectors.toList());
    }

}
