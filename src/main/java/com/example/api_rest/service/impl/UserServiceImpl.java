package com.example.api_rest.service.impl;

import com.example.api_rest.domain.model.User;
import com.example.api_rest.domain.repository.AccountRepository;
import com.example.api_rest.domain.repository.CardRepository;
import com.example.api_rest.domain.repository.FeatureRepository;
import com.example.api_rest.domain.repository.NewsRepository;
import com.example.api_rest.domain.repository.UserRepository;
import com.example.api_rest.dto.UserDTO;
import com.example.api_rest.dto.UserMinDTO;
import com.example.api_rest.service.UserService;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final AccountRepository accountRepository;
    private final CardRepository cardRepository;
    private final FeatureRepository featureRepository;
    private final NewsRepository newsRepository;
    private final UserRepository userRepository;

    public UserServiceImpl(AccountRepository accountRepository, CardRepository cardRepository,
            FeatureRepository featureRepository, NewsRepository newsRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.cardRepository = cardRepository;
        this.featureRepository = featureRepository;
        this.newsRepository = newsRepository;
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO findById(Long id) {
        var user = userRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return new UserDTO(user);
    }

    @Override
    @Transactional
    public UserDTO create(UserMinDTO userToCreate) {
        try {
            User user = new User();
            if (userToCreate.getId() != null) {
                user.setId(userToCreate.getId());
            }
            user.setAccount(accountRepository.findById(userToCreate.getAccountId()).orElseThrow(NoSuchElementException::new));
            user.setFeatures(userToCreate.getFeaturesId().stream()
                    .map(id -> featureRepository.findById(id).orElseThrow(NoSuchElementException::new))
                    .collect(Collectors.toList()));
            user.setCard(cardRepository.findById(userToCreate.getCardId()).orElseThrow(NoSuchElementException::new));
            user.setNews(userToCreate.getNewsIds().stream().map(id -> newsRepository.findById(id).orElseThrow(NoSuchElementException::new))
                    .collect(Collectors.toList()));
            user.setName(userToCreate.getName());
            User savedUser = userRepository.save(user);
            return new UserDTO(savedUser);
        } catch (Exception e) {
            throw new RuntimeException("Unexpected error: " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDTO update(UserMinDTO userToUpdate) {
        if (userToUpdate.getId() != null) {
            return create(userToUpdate);
        } else {
            throw new IllegalArgumentException("Id must not be null");
        }
    }

    @Override
    public List<UserMinDTO> findAll() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserMinDTO::new).collect(Collectors.toList());
    }
}
