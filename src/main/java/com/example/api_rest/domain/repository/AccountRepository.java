package com.example.api_rest.domain.repository;

import com.example.api_rest.domain.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
