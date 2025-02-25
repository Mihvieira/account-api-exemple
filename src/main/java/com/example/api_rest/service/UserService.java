package com.example.api_rest.service;

import java.util.List;

import com.example.api_rest.dto.UserDTO;
import com.example.api_rest.dto.UserMinDTO;

public interface UserService {

    UserDTO findById(Long id);
    UserDTO create(UserMinDTO userToCreate);
    void delete(Long id);
    UserDTO update(UserMinDTO userToUpdate);
    List<UserMinDTO> findAll();
}
