package com.example.api_rest.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.api_rest.domain.model.Account;
import com.example.api_rest.domain.repository.AccountRepository;
import com.example.api_rest.dto.AccountDTO;
import com.example.api_rest.service.AccountService;

import jakarta.transaction.Transactional;

@Service
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDTO findById(Long id) {
        var account = accountRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return new AccountDTO(account);
    }

    @Override
    public AccountDTO create(AccountDTO accountToCreate) {
        try {
            Account account = new Account();
            if (accountToCreate.getId() != null) {
                    account.setId(accountToCreate.getId());
                }
                account.setAgency(accountToCreate.getAgency());
                account.setNumber(accountToCreate.getNumber());
                account.setBalance(accountToCreate.getBalance());
                account.setLimit(accountToCreate.getLimit());
                Account savedAccount = accountRepository.save(account);
                return new AccountDTO(savedAccount);
        } catch (Exception e) {
            throw new RuntimeException("Unexpected error: " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
        accountRepository.deleteById(id);
    }

    @Override
    public AccountDTO update(AccountDTO accountToUpdate) {
        if (accountToUpdate.getId() != null) {
            return create(accountToUpdate);
        }else{
            throw new IllegalArgumentException("Id must not be null");
        } 
    }

    @Override
    public List<AccountDTO> findAll() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map(AccountDTO::new).collect(Collectors.toList());
    }

}
