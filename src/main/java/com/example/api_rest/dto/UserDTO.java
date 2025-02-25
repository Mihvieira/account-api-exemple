package com.example.api_rest.dto;

import java.util.List;

import com.example.api_rest.domain.model.Account;
import com.example.api_rest.domain.model.Card;
import com.example.api_rest.domain.model.Feature;
import com.example.api_rest.domain.model.News;
import com.example.api_rest.domain.model.User;

public class UserDTO {

    private Long id;
    private String name;
    private Account account;
    private List<Feature> features;
    private Card card;
    private List<News> news;

    public UserDTO() {
    }

    public UserDTO(User user){
        if (user.getId() != null){
            setId(user.getId());
        }
        setAccount(user.getAccount());
        setCard(user.getCard());
        setNews(user.getNews());
        setFeatures(user.getFeatures());
        setName(user.getName());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        UserDTO other = (UserDTO) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
