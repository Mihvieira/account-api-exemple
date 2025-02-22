package com.example.api_rest.domain.repository;

import com.example.api_rest.domain.model.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {

}
