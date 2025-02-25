package com.example.api_rest.dto;

import java.math.BigDecimal;

import com.example.api_rest.domain.model.Account;

public class AccountDTO {

    private Long id;
    private String number;
    private String agency;
    private BigDecimal balance;
    private BigDecimal limit;

    public AccountDTO() {
    }


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

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
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
        AccountDTO other = (AccountDTO) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    

}
