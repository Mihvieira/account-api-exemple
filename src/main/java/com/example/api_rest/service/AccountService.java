package com.example.api_rest.service;

import java.util.List;

import com.example.api_rest.dto.AccountDTO;

public interface AccountService {

    AccountDTO findById(Long id);

    AccountDTO create(AccountDTO accountToCreate);

    void delete(Long id);

    AccountDTO update(AccountDTO accountToUpdate);

    List<AccountDTO> findAll();

}
