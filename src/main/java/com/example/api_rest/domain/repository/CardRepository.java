package com.example.api_rest.domain.repository;

import com.example.api_rest.domain.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
}
