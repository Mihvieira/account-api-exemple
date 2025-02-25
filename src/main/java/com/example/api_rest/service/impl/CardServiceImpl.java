package com.example.api_rest.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.api_rest.domain.model.Card;
import com.example.api_rest.domain.repository.CardRepository;
import com.example.api_rest.dto.CardDTO;
import com.example.api_rest.service.CardService;

@Service
public class CardServiceImpl implements CardService{

    private final CardRepository cardRepository;

    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public CardDTO findById(Long id) {
        var card = cardRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return new CardDTO(card);
    }

    @Override
    public CardDTO create(CardDTO cardToCreate) {
        try {
            Card card = new Card();
            if (cardToCreate.getId() != null) {
                card.setId(cardToCreate.getId());
            }
            card.setLimit(cardToCreate.getLimit());
            card.setNumber(cardToCreate.getNumber());
            Card savedCard = cardRepository.save(card);
            return new CardDTO(savedCard);
        } catch (Exception e) {
            throw new RuntimeException("Unexpected error: " + e.getMessage());
        }
    }

    @Override
    public List<CardDTO> findAll() {
        List<Card> cards = cardRepository.findAll();
        return cards.stream().map(CardDTO::new).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        cardRepository.deleteById(id);
    }

    @Override
    public CardDTO update(CardDTO cardToUpdate) {
        if (cardToUpdate.getId() != null) {
            return create(cardToUpdate);
        }else{
            throw new IllegalArgumentException("Id must not be null");
        }
    }

}
