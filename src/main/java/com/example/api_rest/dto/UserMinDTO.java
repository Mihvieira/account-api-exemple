package com.example.api_rest.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.api_rest.domain.model.User;

public class UserMinDTO {

    private Long id;
    private String name;
    private Long accountId;
    private List<Long> featuresId = new ArrayList<>();
    private Long cardId;
    private List<Long> newsIds = new ArrayList<>();

    public UserMinDTO() {
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public List<Long> getFeaturesId() {
        return featuresId;
    }

    public void setFeaturesId(List<Long> featuresId) {
        this.featuresId = featuresId;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public List<Long> getNewsIds() {
        return newsIds;
    }

    public void setNewsIds(List<Long> newsIds) {
        this.newsIds = newsIds;
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
        UserMinDTO other = (UserMinDTO) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    

}
