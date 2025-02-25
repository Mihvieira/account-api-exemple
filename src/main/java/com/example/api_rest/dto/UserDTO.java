package com.example.api_rest.dto;

import java.util.List;

import com.example.api_rest.domain.model.Account;
import com.example.api_rest.domain.model.Card;
import com.example.api_rest.domain.model.Feature;
import com.example.api_rest.domain.model.News;
import com.example.api_rest.domain.model.User;

import lombok.Data;

@Data
public class UserDTO {

    private Long id;
    private Account account;
    private List<Feature> features;
    private Card card;
    private List<News> news;

    public UserDTO(User user){
        if (user.getId() != null){
            setId(user.getId());
        }
        setAccount(user.getAccount());
        setCard(user.getCard());
        setNews(user.getNews());
        setFeatures(user.getFeatures());
    }

}
