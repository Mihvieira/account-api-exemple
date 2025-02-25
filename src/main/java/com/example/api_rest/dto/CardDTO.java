package com.example.api_rest.dto;

import java.math.BigDecimal;

import com.example.api_rest.domain.model.Card;

import lombok.Data;

@Data
public class CardDTO {

    private Long id;
    private String number;
    private BigDecimal limit;

    public CardDTO(String number, BigDecimal limit) {
        this.number = number;
        this.limit = limit;
    }

    public CardDTO(Card card) {
        if (card.getId() != null){
            setId(card.getId());
        }
        setLimit(card.getLimit());
        setNumber(card.getNumber());
    }   

}
