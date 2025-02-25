package com.example.api_rest.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.api_rest.domain.model.User;

import lombok.Data;

@Data
public class UserMinDTO {

    private Long id;
    private String name;
    private Long accountId;
    private List<Long> featuresId = new ArrayList<>();
    private Long cardId;
    private List<Long> newsIds = new ArrayList<>();

    public UserMinDTO(String name, Long accountId, List<Long> featuresId, Long cardId, List<Long> newsIds) {
        this.name = name;
        this.accountId = accountId;
        this.featuresId = featuresId;
        this.cardId = cardId;
        this.newsIds = newsIds;
    }

    public UserMinDTO(User user) {
        if (user.getId() != null){
            setId(user.getId());
        }
        setAccountId(user.getAccount().getId());
        setCardId(user.getCard().getId());
        setNewsIds(user.getNews().stream().map(news -> news.getId()).collect(Collectors.toList()));
        setFeaturesId(user.getFeatures().stream().map(feature -> feature.getId()).collect(Collectors.toList()));
    }

    

}
