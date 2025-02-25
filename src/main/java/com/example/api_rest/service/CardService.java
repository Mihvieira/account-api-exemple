package com.example.api_rest.service;

import java.util.List;

import com.example.api_rest.dto.CardDTO;

public interface CardService {

    CardDTO findById(Long id);
    CardDTO create(CardDTO card);
    List<CardDTO> findAll();
    void delete(Long id);
    CardDTO update(CardDTO cardToUpdate);

}
