package com.example.api_rest.dto;

import java.math.BigDecimal;

import com.example.api_rest.domain.model.Card;

public class CardDTO {

    private Long id;
    private String number;
    private BigDecimal limit;

    public CardDTO() {
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
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
        CardDTO other = (CardDTO) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }  


    

}
