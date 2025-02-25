package com.example.api_rest.dto;

import java.math.BigDecimal;

import com.example.api_rest.domain.model.Account;

import lombok.Data;

@Data
public class AccountDTO {

    private Long id;
    private String number;
    private String agency;
    private BigDecimal balance;
    private BigDecimal limit;

    public AccountDTO(String number, String agency, BigDecimal balance, BigDecimal limit) {
        this.number = number;
        this.agency = agency;
        this.balance = balance;
        this.limit = limit;
    }

    public AccountDTO(Account account) {
        if (account.getId() != null){
            setId(account.getId());
        }
        setAgency(account.getAgency());
        setBalance(account.getBalance());
        setLimit(account.getLimit());
        setNumber(account.getNumber());
    }

    

}
